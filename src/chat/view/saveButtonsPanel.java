package chat.view;

import chat.controller.ChatController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class saveButtonsPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JButton saveButton;
	private JButton openButton;
	
	public saveButtonsPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		saveButton = new JButton("Save");
		openButton = new JButton("Open");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
	}
	
	private void setupLayout()
	{
		this.add(saveButton);
		this.add(openButton);
	}
	
	private void setupListeners()
	{
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		openButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
	}
}
