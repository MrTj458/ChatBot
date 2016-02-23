package chat.view;

import chat.controller.ChatController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class twitterPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JButton tweetButton;
	private JButton checkTwitterButton;
	
	public twitterPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		tweetButton = new JButton("Tweet");
		checkTwitterButton = new JButton("Check Twitter");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(tweetButton);
		this.add(checkTwitterButton);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		checkTwitterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
	}
}
