package chat.controller;

import chat.view.ChatView;
import chat.view.ChatFrame;
import chat.model.Chatbot;
import chat.model.CTECTwitter;

/**
 * Controller for the Chatot project.
 * 
 * @author thod0127
 * @version 1.8 10/28/15 Added components for gui.
 */
public class ChatController
{
	private Chatbot simpleBot;
	private ChatView display;
	private ChatFrame chatFrame;
	private CTECTwitter chatTwitter;
	
	/**
	 * Default constructor for the program.
	 */
	public ChatController()
	{
		chatTwitter = new CTECTwitter(this);
		display = new ChatView();
		String user = display.getAnswer("What is your name?");
		simpleBot = new Chatbot(user);
		chatFrame = new ChatFrame(this);
	}
	
	/**
	 * Runs on program startup.
	 */
	public void start()
	{
		//display.displayPopup("Hello " + simpleBot.getUserName() + ".");
		//chat();
	}
	
	/**
	 * Controls all of the chatbot conversations throught popups.
	 */
	private void chat()
	{
		String conversation = display.getAnswer("What would  like to talk about today?");
		while (simpleBot.lengthChecker(conversation))
		{
			conversation = simpleBot.processConversation(conversation);
			conversation = display.getAnswer(conversation);
		}
	}
	
	/**
	 * Connects the info from the chatPanel and the Chatbot.
	 * @param conversation
	 * @return
	 */
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
	
	/**
	 * Closes the program when the user types 'quit'.
	 */
	private void shutDown()
	{
		display.displayPopup("Goodbye " + simpleBot.getUserName() + ", see you again soon");
		System.exit(0);
	}
	
	public void handleErrors(String error)
	{
		display.displayPopup(error);
	}
	
	public void sendTweet(String tweet)
	{
		chatTwitter.sendTweet(tweet);
	}
	
	public String analyze(String userName)
	{
		String userAnalysis = "The Twitter user " + userName + " Has ....";
		
		return userAnalysis;
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
