package chat.view;

import chat.controller.ChatController;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * This is the panel for the GUI. Contains all of the GUI components.
 * @author thod0127
 * @version 1.7 Added the submitted method.
 */
public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JTextArea chatTextArea;
	private JButton submitButton;
	private JTextField chatTextField;
	private JLabel funnyLabel;
	
	/**
	 * Default constructor for the JPanel.
	 * @param baseController
	 */
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatTextArea = new JTextArea("Hello " + baseController.getChatbot().getUserName() + " What would you like to talk about?");
		submitButton = new JButton("Submit");
		chatTextField = new JTextField();
		funnyLabel = new JLabel("Talking to " + baseController.getChatbot().getUserName() + ".");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	/**
	 * Sets up the panel by adding all of the components and their settings.
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.gray);
		this.add(chatTextArea);
		chatTextArea.setBackground(Color.lightGray);
		chatTextArea.setEnabled(false);
		this.add(submitButton);
		this.add(chatTextField);
		chatTextField.setToolTipText("Type here for the Chat Bot");
		this.add(funnyLabel);
	}
	
	/**
	 * Sets up the locations for all of the components.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatTextArea, -5, SpringLayout.NORTH, chatTextField);
		baseLayout.putConstraint(SpringLayout.NORTH, chatTextField, -1, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.WEST, chatTextField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatTextField, -6, SpringLayout.WEST, submitButton);
		baseLayout.putConstraint(SpringLayout.WEST, chatTextArea, 0, SpringLayout.WEST, chatTextField);
		baseLayout.putConstraint(SpringLayout.EAST, chatTextArea, 0, SpringLayout.EAST, submitButton);
		baseLayout.putConstraint(SpringLayout.NORTH, chatTextArea, 6, SpringLayout.SOUTH, funnyLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, funnyLabel, 0, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, funnyLabel, 155, SpringLayout.WEST, this);
	}
	
	/**
	 * Sets up the listeners for the submitButton and the chatTextField.
	 */
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				submitted();
			}
		});
		
		chatTextField.addKeyListener(new KeyListener()
		{
			public void keyTyped(KeyEvent typed)
			{

			}
			
			public void keyPressed(KeyEvent pressed)
			{
				if(pressed.getKeyCode() == KeyEvent.VK_ENTER)
				{
					submitted();
				}
			}
			
			public void keyReleased(KeyEvent released)
			{
				
			}
		});
	}
	
	/**
	 * Sends the user input to the controller and displays the chatbot's response.
	 */
	private void submitted()
	{
		if(!chatTextField.getText().equals(""))
		{
			String userText = chatTextField.getText();
			String response = baseController.fromUserToChatbot(userText);
			chatTextArea.append("\nUser: " + userText);
			chatTextArea.append("\nChatBot: " + response);
			chatTextField.setText("");
		}
	}
	
	public JTextField getTextField()
	{
		return chatTextField;
	}
}
