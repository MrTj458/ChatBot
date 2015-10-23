package chat.view;

import javax.swing.JOptionPane;

/**
 * This class provides GUI pop-ups for inputing and outputing Strings.
 * 
 * @author thod0127
 * @version 1.0 10/21/15
 */
public class ChatView
{

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
