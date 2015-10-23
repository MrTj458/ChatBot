package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot;

/**
 * Controller for the Chatot project.
 * @author thod0127
 * @version 1.2 10/23/15 Displays the Chatbot's userName variable.
 */
public class ChatController
{
	private Chatbot simplebot;
	private ChatView display;
	
	public ChatController()
	{
		display = new ChatView();
		String user = display.getAnswer("What is your name?");
		simplebot = new Chatbot(user);
	}
	
	public void start()
	{
		display.displayPopup("Hello " + simplebot.getUserName() + ".");
	}
	
}
