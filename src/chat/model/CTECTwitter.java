package chat.model;

import java.util.ArrayList;
import twitter4j.*;
import chat.controller.ChatController;

/**
 * CTECTwitter class
 * @author thod0127
 * @version 0.1 3/7/16 Added sendTweet message
 */
public class CTECTwitter
{
	private ArrayList<Status> statusList;
	private ArrayList<String> wordsList;
	private Twitter chatbotTwitter;
	private ChatController baseController;
	
	public CTECTwitter(ChatController baseController)
	{
		this.statusList = new ArrayList<Status>();
		this.wordsList = new ArrayList<String>();
		this.chatbotTwitter = TwitterFactory.getSingleton();
		this.baseController = baseController;
	}
	
	/**
	 * Sends a tweet
	 * @param message
	 */
	public void sendTweet(String message)
	{
		try
		{
			chatbotTwitter.updateStatus(message);
		}
		catch (TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
	}
}
