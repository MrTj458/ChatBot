package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot;

/**
 * Controller for the Chatot project.
 * 
 * @author thod0127
 * @version 1.3 10/23/15 The chatbot now chats.
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
		chat();
	}

	private void chat()
	{
		String textFromUser = display.getAnswer("Talk to the chatbot");
		while (simplebot.lengthChecker(textFromUser))
		{
			display.displayPopup("wow " + textFromUser);
		}
	}

}
