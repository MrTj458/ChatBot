package chat.view;

import chat.controller.ChatController;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JTextArea chatTextArea;
	private JButton submitButton;
	private JTextField chatTextField;
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatTextArea = new JTextArea("This is text.");
		submitButton = new JButton("Submit");
		chatTextField = new JTextField("Talk to the Chat Bot!");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.gray);
		this.add(chatTextArea);
		chatTextArea.setBackground(Color.lightGray);
		
		
		this.add(submitButton);
		this.add(chatTextField);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatTextArea, -5, SpringLayout.NORTH, chatTextField);
		baseLayout.putConstraint(SpringLayout.NORTH, chatTextField, -1, SpringLayout.NORTH, submitButton);
		baseLayout.putConstraint(SpringLayout.WEST, chatTextField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatTextField, -6, SpringLayout.WEST, submitButton);
		baseLayout.putConstraint(SpringLayout.NORTH, chatTextArea, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatTextArea, 0, SpringLayout.WEST, chatTextField);
		baseLayout.putConstraint(SpringLayout.EAST, chatTextArea, 0, SpringLayout.EAST, submitButton);
	}
	
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				chatTextArea.setText(chatTextField.getText());
				chatTextField.setText("Chat some more!");
			}
		});
		
		chatTextField.addKeyListener(new KeyListener()
		{
			public void keyTyped(KeyEvent typed)
			{
				
			}
			
			public void keyPressed(KeyEvent pressed)
			{
				
			}
			
			public void keyReleased(KeyEvent released)
			{
				if(released.getKeyCode() == KeyEvent.VK_ENTER)
				{
					chatTextArea.setText(chatTextField.getText());
					chatTextField.setText("Chat some more!");
				}
			}
		});
	}
}
