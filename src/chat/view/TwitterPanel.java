package chat.view;

import chat.controller.ChatController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwitterPanel extends JPanel
{
	private ChatController baseController;
	private ChatPanel basePanel;
	private SpringLayout baseLayout;
	private JButton tweetButton;
	private JButton checkTwitterButton;
	private JTextField tweetField;
	
	public TwitterPanel(ChatController baseController, ChatPanel basePanel)
	{
		this.baseController = baseController;
		this.basePanel = basePanel;
		baseLayout = new SpringLayout();
		tweetButton = new JButton("Tweet");
		checkTwitterButton = new JButton("Check Twitter");
		tweetField = new JTextField("Tweet");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setPreferredSize(new Dimension(200,120));
		this.add(tweetButton);
		this.add(checkTwitterButton);
		this.add(tweetField);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, checkTwitterButton, 34, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, checkTwitterButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, tweetButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, tweetField, 7, SpringLayout.SOUTH, tweetButton);
		baseLayout.putConstraint(SpringLayout.WEST, tweetField, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, tweetField, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, tweetButton, 59, SpringLayout.WEST, this);
	}
	
	private void setupListeners()
	{
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				if(tweetField.getText().equals("") || tweetField.getText().equals(null) || tweetField.getText().equals("tweet") || tweetField.getText().equals("Tweet"))
				{
					baseController.getChatView().displayPopup("Type in a message to tweet first!");
				}
				else
				{
					baseController.sendTweet(tweetField.getText() + " @ChatbotCTEC");
				}
			}
		});
		
		checkTwitterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String user = basePanel.getTextField().getText();
				String results = baseController.analyze(user);
				basePanel.getTextArea().setText(results);
			}
		});
	}
}
