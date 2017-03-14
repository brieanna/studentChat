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
import java.net.InetAddress;
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

	private String username;
	private InetAddress ip;
	private int port = 8090;
	private Socket sock;
	private BufferedReader reader;
	private PrintWriter writer;
	private ArrayList<String> userList = new ArrayList<String>();
	private Boolean isConnected = false;

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
			/*
			 * TODO: need to check to see if there is a server (if there is a
			 * server, connect) need to check if the User name is unique to the
			 * list of user names (if the user name is unique, connect) if there
			 * is not a server or the user name is not unique then start new
			 * server (run below actionPerformed after starting ServerWithGUI)
			 */

			// TODO: need to find a way to send over the user name and have the
			// server check the name before creating our own server.
			// need to make sure that my server checks for duplicate user names
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isConnected == false) {
					username = nameTextArea.getText();
					nameTextArea.setEditable(false);

					try {
						// this is what checks for an existing server
						sock = new Socket(ip.getByName(ipTextArea.getText()), port);
						InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
						reader = new BufferedReader(streamreader);
						writer = new PrintWriter(sock.getOutputStream());
						writer.println(username);
						writer.flush();
						isConnected = true;

					} catch (Exception ex) {
						chatTextArea.append("DENY  Start Server and Connect again.\n");
						ServerWithGUI server = new ServerWithGUI();
						server.runServerWithGUI();
					}
					Thread IncomingReader = new Thread(new IncomingReader());
					IncomingReader.start();
				} else if (isConnected == true) {
					chatTextArea.append("dumbACK You are already connected. \n");
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
				writer.println(replyTextArea.getText());
				writer.flush();
			} catch (Exception ex) {
				chatTextArea.append("Please enter IP and UserName to connect. \n");
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
				while (sock.isConnected() && !sock.isClosed()) {
					stream = reader.readLine();
					chatTextArea.append(stream);

				}
			} catch (Exception ex) {
			}
		}
	}

	public void disconnect() {
		String bye = (username + ": :Disconnect");
		try {
			writer.println(bye); // Sends server the disconnect signal.
			writer.flush(); // flushes the buffer
		} catch (Exception e) {
			chatTextArea.append("Could not send Disconnect message.\n");
		}

		try {
			chatTextArea.append("Disconnected.\n");
			sock.close();
		} catch (Exception ex) {
			chatTextArea.append("Failed to disconnect. \n");
		}
		isConnected = false;
		nameTextArea.setEditable(true);
	}

}
