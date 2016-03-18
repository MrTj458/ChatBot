package chat.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
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
	
	public String topResults()
	{
		String tweetResults = "";
		
		int topWordLocation = 0;
		int topCount = 0;
		
		for(int index = 0; index < wordsList.size(); index++)
		{
			int wordUseCount = 1;
			
			for(int spot = index + 1; spot < wordsList.size(); spot++)
			{
				if(wordsList.get(index).equals(wordsList.get(spot)))
				{
					wordUseCount++;
				}
				if(wordUseCount > topCount)
				{
					topCount = wordUseCount;
					topWordLocation = index;
				}
			}
		}
		
		tweetResults = "The top word is: " + wordsList.get(topWordLocation) + " and it was used " + topCount + " times!";
	
		return tweetResults;
	}

	public void loadTweets(String twitterHandle) throws TwitterException
	{
		statusList.clear();
		wordsList.clear();
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
			String[] wordList = currentStatus.getText().split(" ");
			for(String word : wordList)
			{
				wordsList.add(removePunctuation(word).toLowerCase());
			}
		}
		removeCommonEnglishWords(wordsList);
		removeEmptyText();
	}
	
	private List removeCommonEnglishWords(List<String> wordsList)
	{
		String[] boringWords = importWordsToArray();
		
		for(int count = 0; count < wordsList.size(); count++)
		{
			for(int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
			{
				if(wordsList.get(count).equalsIgnoreCase(boringWords[removeSpot]))
				{
					wordsList.remove(count);
					count--;
					removeSpot = boringWords.length;
				}
			}
		}
//		removeTwitterUsernamesFromList(wordsList);
		
		return wordsList;
	}
	
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,'?!:;\"()[]{}<>-";
		
		String scrubbedString = "";
		for(int i = 0; i < currentString.length(); i++)
		{
			if(punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}
	
	private void removeEmptyText()
	{
		for(int spot = 0; spot < wordsList.size(); spot++)
		{
			if(wordsList.get(spot).equals(""))
			{
				wordsList.remove(spot);
				spot--;
			}
		}
	}
	
	private void removeTwitterUsernamesFromList(List<String> wordsList)
	{
		for(int wordCount = 0; wordCount < wordsList.size(); wordCount++)
		{
			if(wordsList.get(wordCount).length() >= 1 && wordsList.get(wordCount).charAt(0) == '@')
			{
				wordsList.remove(wordCount);
				wordCount--;
			}
		}
	}
	
	private String[] importWordsToArray()
	{
		String[] boringWords;
		int wordCount = 0;
	
			Scanner wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
			while(wordFile.hasNext())
			{
				wordCount++;
				wordFile.next();
			}
			wordFile.close();
			wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
			boringWords = new String[wordCount];
			int boringWordCount = 0;
			while(wordFile.hasNext())
			{
				boringWords[boringWordCount] = wordFile.next();
				boringWordCount++;
			}
			wordFile.close();
			return boringWords;
	}
}
