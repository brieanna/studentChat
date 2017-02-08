package studentChat;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class ChatGUI extends JFrame {
	private JFrame frame;
	private JPanel southPanel;
	private JPanel middlePanel;
	private JPanel panel;
	private JButton sendButton;
	private JTextArea replyTextArea;
	private JTextArea chatTextArea;
	private JScrollPane replyScrollPane;
	private JScrollPane chatScrollPane;
	
	public ChatGUI(){
		
		}
	
	public void runChatGUI(){
		
		frame = new JFrame();
		frame.setSize(400, 400);
		panel = new JPanel();
		GridLayout layout = new GridLayout(3,1, 10, 10);
		panel.setLayout(layout);
		frame.add(panel);
		
		String user = "User says: ";
		Group group = new Group();
		String groupChat = group.beginConvo();
		
		chatTextArea = new JTextArea(35,30);
		chatTextArea.setLineWrap(true);
		chatTextArea.setEditable(false);
		chatTextArea.setText(groupChat);
		chatScrollPane = new JScrollPane(chatTextArea);
		chatScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		chatScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		replyTextArea = new JTextArea(8, 20);
		replyTextArea.setLineWrap(true);
		replyTextArea.setEditable(true);
		replyScrollPane = new JScrollPane(replyTextArea);
		replyScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		replyScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		replyTextArea.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				
				if((e.getKeyCode() == KeyEvent.VK_ENTER && (e.isMetaDown()))){
					chatTextArea.setText(chatTextArea.getText() + "\n" + user + replyTextArea.getText());
					replyTextArea.setText("");
		        }else{
		        	
		        }
				
			}

			@Override
			public void keyReleased(KeyEvent e) {}});
		
		sendButton = new JButton();
		sendButton.setText("Send");
		sendButton.setSize(5, 5);
		sendButton.setBackground(Color.CYAN);
		sendButton.setOpaque(true);
		sendButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				chatTextArea.setText(chatTextArea.getText() + "\n" + replyTextArea.getText());	
				replyTextArea.setText("");
			}});
	
		

		panel.add(chatScrollPane);
		panel.add(replyScrollPane);
		panel.add(sendButton);

		
		
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	}

}
