package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * This class provides GUI pop-ups for inputing and outputing Strings.
 * 
 * @author thod0127
 * @version 1.1 Added constructor
 */
public class ChatView
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatView()
	{
		windowMessage = "This message brought to you by the chatbot!";
		chatIcon = new ImageIcon(getClass().getResource("images/dogeIconBetter.png"));
	}
	
	/**
	 * Shows a InputDialog GUI pop-up to get an answer from the user.
	 * 
	 * @param displayMessage
	 *            The message to be displayed.
	 * @return answer as a String
	 */
	public String getAnswer(String displayMessage)
	{
		String answer = "";
		
		answer = JOptionPane.showInputDialog(null, displayMessage);
		
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
		JOptionPane.showMessageDialog(null, displayMessage);
	}
	
}
