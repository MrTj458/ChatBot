package chat.view;

import chat.controller.ChatController;
import javax.swing.JFrame;

/**
 * The JFrame for the GUI
 * @author thod0127
 * @version 1.0
 */
public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel basePanel;
	
	/**
	 * Default constructor for the JFrame.
	 * @param baseController
	 */
	public ChatFrame(ChatController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatPanel(baseController);
		
		setupFrame();
	}
	
	/**
	 * Sets up all of the settings for the JFrame.
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setResizable(false);
		this.setSize(400, 400);
		this.setTitle("Chat Bot");
		this.setVisible(true);
	}
	
	public ChatController getBaseController()
	{
		return baseController;
	}
}
