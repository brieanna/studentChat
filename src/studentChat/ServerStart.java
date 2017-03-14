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
			server = new ServerSocket(8090);
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

