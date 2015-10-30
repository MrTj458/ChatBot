package chat.controller;

import chat.view.ChatView;
import chat.model.Chatbot;

/**
 * Controller for the Chatot project.
 * 
 * @author thod0127
 * @version 1.5 10/28/15 Now checks for memes.
 */
public class ChatController
{
	private Chatbot simpleBot;
	private ChatView display;
	
	public ChatController()
	{
		display = new ChatView();
		String user = display.getAnswer("What is your name?");
		simpleBot = new Chatbot(user);
	}
	
	public void start()
	{
		display.displayPopup("Hello " + simpleBot.getUserName() + ".");
		chat();
	}
	
	private void chat()
	{
		String conversation = display.getAnswer("What would  like to talk about today?");
		while (simpleBot.lengthChecker(conversation))
		{
			if(simpleBot.contentChecker(conversation))
			{
				display.displayPopup("Wow I didn't know you liked " + simpleBot.getContent());
			}
			else if(simpleBot.memeChecker(conversation))
			{
				display.displayPopup("That's my favourite meme!");
			}
			
			conversation = display.getAnswer(conversation);
		}
	}
	
}
