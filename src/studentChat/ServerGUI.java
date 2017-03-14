package studentChat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ServerGUI extends JFrame {
	private static final long serialVersionUID = 1L;

	private String ip;
	private String name;

	public ServerGUI() {

	}

	ChatGUI chat = new ChatGUI();

	public void runServerGUI() {
		JFrame frame = new JFrame();
		frame.setSize(200, 150);
		JPanel panel = new JPanel();
		JPanel ipPanel = new JPanel();

		JLabel ipLabel = new JLabel();
		ipLabel.setText("Enter IP:");
		ipPanel.add(ipLabel);

		JTextArea ipTextArea = new JTextArea(1, 10);
		ipTextArea.setEditable(true);
		ipPanel.add(ipTextArea);

		JLabel nameLabel = new JLabel();
		nameLabel.setText("Enter UserName:");
		panel.add(nameLabel);

		JTextArea nameTextArea = new JTextArea(1, 10);
		nameTextArea.setEditable(true);
		panel.add(nameTextArea);

		JButton connectButton = new JButton();
		connectButton.setText("Connect");
		connectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ip = ipTextArea.getText();
				ipTextArea.setEditable(false);

				System.out.println(ip);

				name = nameTextArea.getText();
				nameTextArea.setText("");

				System.out.println(name);

			}
		});
		panel.add(connectButton);

		frame.add(ipPanel, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);

	}
}
