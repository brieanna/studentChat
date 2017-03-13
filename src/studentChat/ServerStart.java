package studentChat;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerStart {
	ServerSocket server;

	public ServerStart() {
		try {
			server = new ServerSocket(8080);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		while (true) {
			try {
				new Thread(new InputHandler(server.accept())).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new ServerStart();
	}

	private class InputHandler implements Runnable {
		private Reader r;
		private PrintWriter w;
		private Socket s;

		public InputHandler(Socket s) throws IOException {
			this.s = s;
			System.out.println(s.getInetAddress());
			this.r = new InputStreamReader(s.getInputStream());
			this.w = new PrintWriter(s.getOutputStream());
		}

		@Override
		public void run() {
			char character = 0;
			try {
				while ((character = (char) r.read()) != -1) {
					System.out.println(s.getInetAddress() + ": " + character);
					w.write(character);
					w.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
// package studentChat;
//
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.io.PrintWriter;
// import java.net.ServerSocket;
// import java.net.Socket;
// import java.util.ArrayList;
//
//
// public class ServerStart implements Runnable {
// private PrintWriter outputPane;
// private ArrayList clientOutputStreams;
// private ArrayList onlineUsers;
//
// public void run() {
// clientOutputStreams = new ArrayList();
// onlineUsers = new ArrayList();
//
// try {
// ServerSocket serverSock = new ServerSocket(8090);
//
// while (true) {
// Socket clientSock = serverSock.accept();
// PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
// clientOutputStreams.add(writer);
//
// Thread listener = new Thread(new ClientHandler(clientSock, writer));
// listener.start();
// outputPane.append("Got a connection. \n");
// }
// }
// catch (Exception ex) {
// outputPane.append("Error making a connection. \n");
// }
//
// }
// }
