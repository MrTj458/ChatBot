package chat.model;

import java.util.ArrayList;
import twitter4j.*;

public class CTECTwitter
{
	private ArrayList<Status> statusList;
	private ArrayList<String> wordsList;
	
	public CTECTwitter()
	{
		this.statusList = new ArrayList<Status>();
		this.wordsList = new ArrayList<String>();
	}
	
	public void sendTweet(String message)
	{
		
	}
}
