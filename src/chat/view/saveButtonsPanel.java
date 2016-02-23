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
		this.setSize(new Dimension(130, 100));
		this.add(saveButton);
		this.add(openButton);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, openButton, 26, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, openButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, saveButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, saveButton, 27, SpringLayout.WEST, this);
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
