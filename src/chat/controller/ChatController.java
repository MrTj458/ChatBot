package chat.controller;

import chat.view.ChatPopupView;

/**
 * 
 * @author thod0127
 * @version 1.0 10/21/15
 */
public class ChatController
{
	
	private ChatPopupView popups;
	
	public ChatController()
	{
		popups = new ChatPopupView();
	}
	
	public void start()
	{
		popups.displayPopup("Testing!");
	}
	
}
