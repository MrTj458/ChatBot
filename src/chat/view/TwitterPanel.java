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
	private JButton investigateButton;
	
	public TwitterPanel(ChatController baseController, ChatPanel basePanel)
	{
		this.baseController = baseController;
		this.basePanel = basePanel;
		baseLayout = new SpringLayout();
		tweetButton = new JButton("Tweet");
		checkTwitterButton = new JButton("Check Twitter");
		investigateButton = new JButton("Investigate");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setPreferredSize(new Dimension(200, 118));
		this.add(tweetButton);
		this.add(checkTwitterButton);
		this.add(investigateButton);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, tweetButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, tweetButton, 59, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, investigateButton, 6, SpringLayout.SOUTH, checkTwitterButton);
		baseLayout.putConstraint(SpringLayout.WEST, investigateButton, 43, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, checkTwitterButton, 6, SpringLayout.SOUTH, tweetButton);
		baseLayout.putConstraint(SpringLayout.WEST, checkTwitterButton, 34, SpringLayout.WEST, this);
	}
	
	private void setupListeners()
	{
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				JTextField tempField = basePanel.getTextField();
				
				if(tempField.getText().equals("") || tempField.getText().equals(null) || tempField.getText().equals("tweet") || tempField.getText().equals("Tweet"))
				{
					baseController.getChatView().displayPopup("Type in a message to tweet first!");
				}
				else
				{
					baseController.sendTweet(tempField.getText() + " @ChatbotCTEC");
				}
			}
		});
		
		checkTwitterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String user = basePanel.getTextField().getText();
				String results = baseController.analyze(user);
				basePanel.getTextArea().append(results + "\n");
			}
		});
		
		investigateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String result = baseController.investigate();
				basePanel.getTextArea().append(result + "\n");
			}
		});
	}
}
