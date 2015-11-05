package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * This class provides GUI pop-ups for inputing and outputing Strings.
 * 
 * @author thod0127
 * @version 1.4 Added icon to display popups.
 */
public class ChatView
{
	private String windowMessage;
	private ImageIcon dogeIcon;
	private ImageIcon fedoraManIcon;
	private ImageIcon smileyIcon;
	
	public ChatView()
	{
		windowMessage = "This message brought to you by the chatbot!";
		dogeIcon = new ImageIcon(getClass().getResource("images/dogeIconBetter.png"));
		fedoraManIcon = new ImageIcon(getClass().getResource("images/fedoraMan.png"));
		smileyIcon = new ImageIcon(getClass().getResource("images/smiley.png"));
	}
	
	/**
	 * Shows a InputDialog GUI pop-up to get an answer from the user.
	 * 
	 * @param displayMessage
	 *            The message to be displayed.
	 * @return answer as a String
	 */
	public String getAnswer(String displayText)
	{
		String answer = "";
		
		answer = JOptionPane.showInputDialog(null, displayText, windowMessage, JOptionPane.PLAIN_MESSAGE, getRandomIcon(), null, "Type here please!").toString();
		
		return answer;
	}
	
	/**
	 * Shows a MessageDialog GUI pop-up to display text.
	 * 
	 * @param displayMessage
	 *            The message to be displayed.
	 */
	public void displayPopup(String displayMessage)
	{
		JOptionPane.showMessageDialog(null, displayMessage, windowMessage, JOptionPane.PLAIN_MESSAGE, getRandomIcon());
	}
	
	private ImageIcon getRandomIcon()
	{
		int randomChoice = (int) (Math.random() * 3);
		
		switch(randomChoice)
		{
			case 0:
				return dogeIcon;
			case 1:
				return fedoraManIcon;
			case 2:
				return smileyIcon;
			default:
				return dogeIcon;
		}
	}
}
