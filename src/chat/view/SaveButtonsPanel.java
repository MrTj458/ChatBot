package chat.view;

import chat.controller.ChatController;
import chat.controller.IOController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SaveButtonsPanel extends JPanel
{
	private ChatController baseController;
	private ChatPanel basePanel;
	private SpringLayout baseLayout;
	private JButton saveButton;
	private JButton openButton;
	private JLabel promptLabel;
	
	public SaveButtonsPanel(ChatController baseController, ChatPanel basePanel)
	{
		this.baseController = baseController;
		this.basePanel = basePanel;
		baseLayout = new SpringLayout();
		saveButton = new JButton("Save");
		openButton = new JButton("Open");
		promptLabel = new JLabel("File: ");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setPreferredSize(new Dimension(130, 105));
		this.add(saveButton);
		this.add(openButton);
		this.add(promptLabel);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, saveButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, saveButton, 27, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, openButton, 6, SpringLayout.SOUTH, saveButton);
		baseLayout.putConstraint(SpringLayout.NORTH, promptLabel, 4, SpringLayout.SOUTH, openButton);
		baseLayout.putConstraint(SpringLayout.WEST, promptLabel, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, openButton, 26, SpringLayout.WEST, this);
	}
	
	private void setupListeners()
	{
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String temp = basePanel.getTextArea().getText();
				String file = IOController.saveFile(basePanel.getTextArea().getText());
				promptLabel.setText(file);
			}
		});
		
		openButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String loadedText = IOController.readTextFromFile(promptLabel.getText());
				basePanel.getTextArea().setText(loadedText);
			}
		});
	}
}
