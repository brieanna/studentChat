package studentChat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class ChatGUI extends JFrame {

	private static final long serialVersionUID = 1L;

	String username, ip = "127.0.0.1";
	int Port = 8090;
	Socket sock;
	BufferedReader reader;
	PrintWriter writer;
	ArrayList<String> userList = new ArrayList();
	Boolean isConnected = false;

	private JFrame frame;
	private JPanel northPanel;
	private JPanel centerPanel;
	private JPanel southPanel;
	private JButton sendButton;
	private JTextArea replyTextArea;
	private JTextArea chatTextArea;
	private JScrollPane replyScrollPane;
	private JScrollPane chatScrollPane;
	private JButton connectButton;
	private JTextArea ipTextArea;
	private JTextArea nameTextArea;
	private JLabel ipLabel;
	private JLabel nameLabel;

	public ChatGUI() {

	}

	public void runChatGUI() {

		frame = new JFrame();
		frame.setSize(460, 400);
		northPanel = new JPanel();
		southPanel = new JPanel();
		centerPanel = new JPanel();

		String user = "You: ";
		Group group = new Group(null, null);
		String groupChat = group.groupChat(group.getRandomGroup());

		ipLabel = new JLabel();
		ipLabel.setText("Enter IP:");
		northPanel.add(ipLabel);

		ipTextArea = new JTextArea(1, 8);
		ipTextArea.setEditable(true);
		northPanel.add(ipTextArea);

		nameLabel = new JLabel();
		nameLabel.setText("Enter UserName:");
		northPanel.add(nameLabel);

		nameTextArea = new JTextArea(1, 7);
		nameTextArea.setEditable(true);
		northPanel.add(nameTextArea);

		connectButton = new JButton();
		connectButton.setText("Connect");
		connectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO : add connection stuffs
				if (isConnected == false) {
					username = nameTextArea.getText();
					nameTextArea.setEditable(false);
					ip = ipTextArea.getText();

					try {
						sock = new Socket(ip, Port);
						InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
						reader = new BufferedReader(streamreader);
						writer = new PrintWriter(sock.getOutputStream());
						writer.println(username + ":has connected.:Connect"); // Displays
																				// to
																				// everyone
																				// that
																				// user
																				// connected.
						writer.flush(); // flushes the buffer
						isConnected = true; // Used to see if the client is
											// connected.
					} catch (Exception ex) {
						chatTextArea.append("DENY \n");
						nameTextArea.setEditable(true);
						String[] args = null;
						ServerStart.main(args);
					}
					Thread IncomingReader = new Thread(new IncomingReader());
					IncomingReader.start();
				} else if (isConnected == true) {
					chatTextArea.append("You are already connected. \n");
				}

			}
		});
		northPanel.add(connectButton);

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
//					chatTextArea.setText(chatTextArea.getText() + "\n" + user + replyTextArea.getText());
//					replyTextArea.setText("");
					sendActionPerformed();
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
				sendActionPerformed();
			}
		});

		southPanel.add(replyScrollPane);
		southPanel.add(sendButton);

		centerPanel.add(chatScrollPane);

		frame.add(northPanel, BorderLayout.NORTH);
		frame.add(centerPanel, BorderLayout.CENTER);
		frame.add(southPanel, BorderLayout.SOUTH);

		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void sendActionPerformed() {
		if ((replyTextArea.getText()).equals("")) {

		} else {
			try {
				writer.println(username + ":" + replyTextArea.getText() + ":" + "Chat");
				writer.flush(); // flushes the buffer
			} catch (Exception ex) {
				chatTextArea.append("Message was not sent. \n");
			}

		}

		replyTextArea.setText("");
		replyTextArea.requestFocus();
	}

	public class IncomingReader implements Runnable {

		public void run() {
			String[] data;
			String stream, done = "Done", connect = "Connect", chat = "Chat";

			try {
				while ((stream = reader.readLine()) != null) {

					data = stream.split(":");

					if (data[2].equals(chat)) {

						chatTextArea.append(data[0] + ": " + data[1] + "\n");
						chatTextArea.setCaretPosition(chatTextArea.getDocument().getLength());

					} else if (data[2].equals(connect)) {

						chatTextArea.removeAll();
						userList.add(data[0]);

					} else if (data[2].equals(done)) { // TODO : determine if
														// this method is even
														// needed

						userList.clear();

					}

				}
			} catch (Exception ex) {
			}
		}
	}

}
