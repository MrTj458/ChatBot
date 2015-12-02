package chat.controller;

import chat.view.ChatView;
import chat.view.ChatFrame;
import chat.model.Chatbot;

/**
 * Controller for the Chatot project.
 * 
 * @author thod0127
 * @version 1.6 10/28/15 Added a check for political topics.
 */
public class ChatController
{
	
	private Chatbot simpleBot;
	private ChatView display;
	private ChatFrame chatFrame;
	
	public ChatController()
	{
		display = new ChatView();
		String user = display.getAnswer("What is your name?");
		simpleBot = new Chatbot(user);
		chatFrame = new ChatFrame(this);
	}
	
	public void start()
	{
		//display.displayPopup("Hello " + simpleBot.getUserName() + ".");
		//chat();
	}
	
	private void chat()
	{
		String conversation = display.getAnswer("What would  like to talk about today?");
		while (simpleBot.lengthChecker(conversation))
		{
			conversation = simpleBot.processConversation(conversation);
			conversation = display.getAnswer(conversation);
		}
	}
	
	public String fromUserToChatbot(String conversation)
	{
		String botResponse = "";
		
		if(simpleBot.quitChecker(conversation))
		{
			shutDown();
		}
		
		botResponse = simpleBot.processConversation(conversation);
		
		return botResponse;
	}
	
	private void shutDown()
	{
		display.displayPopup("Goodbye " + simpleBot.getUserName() + " See you again soon");
		System.exit(0);
	}
	
	public Chatbot getChatbot()
	{
		return simpleBot;
	}
	
	public ChatView getChatView()
	{
		return display;
	}
	
	public ChatFrame getBaseFrame()
	{
		return chatFrame;
	}
	
}
