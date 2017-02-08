package studentChat;
import javax.swing.JFrame;
public class ChatTimes {

	public static void main(String[] args) {
		Group group = new Group();
		group.beginConvo();
		
		ChatGUI chatGUI = new ChatGUI();
		chatGUI.runChatGUI();
		
	}

}
