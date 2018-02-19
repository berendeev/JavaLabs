import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server {
	ServerSocket serverSocket;
	private List<Connection> connections = Collections.synchronizedList(new ArrayList<Connection>());
	private int port;

	Server() {
		port = 6666;
		try {
			serverSocket = new ServerSocket(port);
			while (true) {
				Socket socket = serverSocket.accept();
				Connection user = new Connection(socket);
				connections.add(user);
				user.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Server();
	}

	class Connection extends Thread {
		Socket socket;
		ObjectOutputStream out;
		ObjectInputStream in;

		Connection(Socket socket) {
			this.socket = socket;
			System.err.println("new User");
			try {
				in = new ObjectInputStream(socket.getInputStream());
				out = new ObjectOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {

			while (true) {
				ImageIcon imageIcon;
				try {
					imageIcon = (ImageIcon) in.readObject();

					for (Connection connection : connections) {
						connection.out.writeObject(imageIcon);
					}

				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

