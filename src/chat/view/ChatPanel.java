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
	private JScrollPane textPane;
	private JButton submitButton;
	private JTextField chatTextField;
	private JLabel funnyLabel;
	private SaveButtonsPanel savePanel;
	private TwitterPanel twitterPanel;
	
	/**
	 * Default constructor for the JPanel.
	 * @param baseController
	 */
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		submitButton = new JButton("Submit");
		chatTextField = new JTextField();
		funnyLabel = new JLabel("Talking to " + baseController.getChatbot().getUserName() + ".");
		chatTextArea = new JTextArea("ChatBot: Hello " + baseController.getChatbot().getUserName() + " What would you like to talk about?\n");
		savePanel = new SaveButtonsPanel(baseController);
		twitterPanel = new TwitterPanel(baseController, this);
		
		setupChatPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupChatPane()
	{
		chatTextArea.setLineWrap(true);
		chatTextArea.setWrapStyleWord(true);
		chatTextArea.setEnabled(false);
		chatTextArea.setEditable(false);
		textPane = new JScrollPane(chatTextArea);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	/**
	 * Sets up the panel by adding all of the components and their settings.
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.gray);
		this.add(textPane);
		this.add(submitButton);
		this.add(chatTextField);
		chatTextField.setToolTipText("Type here for the Chat Bot");
		this.add(funnyLabel);
		this.add(savePanel);
		this.add(twitterPanel);
		twitterPanel.setBackground(Color.CYAN);
	}
	
	/**
	 * Sets up the locations for all of the components.
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatTextField, -1, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.WEST, chatTextField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatTextField, -6, SpringLayout.WEST, submitButton);
		baseLayout.putConstraint(SpringLayout.NORTH, chatTextArea, 6, SpringLayout.SOUTH, funnyLabel);
		baseLayout.putConstraint(SpringLayout.EAST, textPane, -20, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatTextArea, 114, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, textPane, 6, SpringLayout.SOUTH, twitterPanel);
		baseLayout.putConstraint(SpringLayout.SOUTH, textPane, -35, SpringLayout.NORTH, chatTextField);
		baseLayout.putConstraint(SpringLayout.EAST, twitterPanel, 0, SpringLayout.EAST, textPane);
		baseLayout.putConstraint(SpringLayout.NORTH, savePanel, 22, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, savePanel, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, textPane, 0, SpringLayout.WEST, chatTextField);
		baseLayout.putConstraint(SpringLayout.NORTH, twitterPanel, 6, SpringLayout.SOUTH, funnyLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatTextArea, -6, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.EAST, chatTextArea, 0, SpringLayout.EAST, submitButton);
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
			chatTextArea.append("User: " + userText + "\n");
			chatTextArea.append("ChatBot: " + response + "\n");
			chatTextField.setText("");
		}
	}
	
	public JTextField getTextField()
	{
		return chatTextField;
	}
	
	public JTextArea getTextArea()
	{
		return chatTextArea;
	}
}
