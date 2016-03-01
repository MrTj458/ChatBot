package chat.view;

import chat.controller.ChatController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwitterPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JButton tweetButton;
	private JButton checkTwitterButton;
	
	public TwitterPanel(ChatController baseController)
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
		this.setSize(new Dimension(130, 100));
		this.add(tweetButton);
		this.add(checkTwitterButton);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, checkTwitterButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, tweetButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, tweetButton, 22, SpringLayout.WEST, this);
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
