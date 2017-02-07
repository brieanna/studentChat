package studentChat;
import java.awt.BorderLayout;
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
	
		
		chatTextArea = new JTextArea(35,30);
		chatTextArea.setLineWrap(true);
		chatTextArea.setEditable(false);
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
			public void keyTyped(KeyEvent e) {
//				KeyStroke.getKeyStroke(KeyEvent.VK_SPACE,
//	                       java.awt.event.InputEvent.CTRL_DOWN_MASK);
//				KeyEvent.VK_META == e.getKeyCode()
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				if((e.getKeyCode() == KeyEvent.VK_ENTER)){
					chatTextArea.setText(chatTextArea.getText() + "\n" + replyTextArea.getText());	
		        }else{
		        	
		        }
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					replyTextArea.setText("");
		        }else{
		        	
		        }
			}});
		
		sendButton = new JButton();
		sendButton.setText("Send");
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
