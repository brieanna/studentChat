package studentChat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class ChatGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel centerPanel;
	private JPanel southPanel;
	private JButton sendButton;
	private JTextArea replyTextArea;
	private JTextArea chatTextArea;
	private JScrollPane replyScrollPane;
	private JScrollPane chatScrollPane;
	private JLabel titleLabel;

	public ChatGUI() {

	}

	public void runChatGUI() {

		frame = new JFrame();
		frame.setSize(400, 400);
		southPanel = new JPanel();
		centerPanel = new JPanel();

		String user = "You: ";
		Group group = new Group(null, null);
		String groupChat = group.groupChat(group.getRandomGroup());

		titleLabel = new JLabel();
		titleLabel.setText("Graphical Chat");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

		chatTextArea = new JTextArea(12, 30);
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
		replyTextArea.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {

				if ((e.getKeyCode() == KeyEvent.VK_ENTER && (e.isMetaDown()))) {
					chatTextArea.setText(chatTextArea.getText() + "\n" + user + replyTextArea.getText());
					replyTextArea.setText("");
				} else {

				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});

		sendButton = new JButton();
		sendButton.setText("Send");
		sendButton.setSize(5, 5);
		sendButton.setBackground(new Color(120, 181, 250));
		sendButton.setOpaque(true);
		sendButton.setBorderPainted(false);
		sendButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				chatTextArea.setText(chatTextArea.getText() + "\n" + user + replyTextArea.getText());
				replyTextArea.setText("");
			}
		});

		southPanel.add(replyScrollPane);
		southPanel.add(sendButton);

		centerPanel.add(chatScrollPane);

		frame.add(titleLabel, BorderLayout.NORTH);
		frame.add(centerPanel, BorderLayout.CENTER);
		frame.add(southPanel, BorderLayout.SOUTH);

		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
