package chat.model;

import java.util.ArrayList;
import java.util.List;
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
	
	public void loadTweets(String twitterHandle) throws TwitterException
	{
		Paging statusPage = new Paging(1, 200);
		int page = 1;
		while(page <= 10)
		{
			statusPage.setPage(page);
			statusList.addAll(chatbotTwitter.getUserTimeline(twitterHandle, statusPage));
			page++;
		}
		for(Status currentStatus : statusList)
		{
			String[] wodsList = currentStatus.getText().split(" ");
			for(String word : wordsList)
			{
				wordsList.add(removePunctuation(word).toLowerCase());
			}
		}
		removeCommonEnglishWords(wordsList);
		removeEmptyText();
	}
	
	private List removeCommonEnglishWords(List<String> wordList)
	{
		return null;
	}
	
	private String removePunctuation(String currentString)
	{
		return null;
	}
	
	private void removeEmptyText()
	{
		
	}
}
