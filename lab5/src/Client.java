import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client {
	private Socket socket;
	private String ip;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private List<JLabel> imageLabels = new ArrayList<>();
	private Panel messagePanel;
	private JFrame frame;

	Client() {
		login();

	}

	public static void main(String[] args) {
		new Client();
	}

	private void login() {
		JFrame frame = new JFrame("Log in");
		frame.setLayout(new GridLayout(2, 2));

		JLabel lbl_ip = new JLabel("Server IP");

		JButton btn_connect = new JButton("Connect");

		JTextField tf_ip = new JTextField("localhost");

		frame.add(lbl_ip);
		frame.add(tf_ip);
		frame.add(btn_connect);

		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setVisible(true);

		btn_connect.addActionListener(e -> {

			ip = tf_ip.getText();
			frame.dispose();
			mainWin();
		});
	}

	public void mainWin() {
		JFrame frame = new JFrame("lab5");
		this.frame = frame;
		frame.setSize(new Dimension(640, 480));

		Panel imagesPanel = new Panel();
		imagesPanel.setLayout(new BoxLayout(imagesPanel, BoxLayout.Y_AXIS));
		frame.add(imagesPanel, BorderLayout.WEST);

		messagePanel = new Panel();
		messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
		frame.add(messagePanel, BorderLayout.CENTER);

		imageLabels.add(new JLabel(new ImageIcon("D:\\Java\\JavaLabs\\lab5\\images\\evil.png")));
		imageLabels.add(new JLabel(new ImageIcon("D:\\Java\\JavaLabs\\lab5\\images\\dead.png")));

		for (JLabel label : imageLabels) {
			imagesPanel.add(label);
		}

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
		connect();
	}

	private void connect() {
		try {
			socket = new Socket(InetAddress.getByName(ip), 6666);
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());

		} catch (IOException e) {
			e.printStackTrace();
		}

		Thread sendThread = new Thread(() -> {
			for (JLabel label : imageLabels) {
				label.addMouseListener(new OverrideMouseListener());
			}
		});
		sendThread.setDaemon(true);
		sendThread.start();

		Thread arrivedThread = new Thread(() -> {
			while (true) {
				try {
					ImageIcon imageIcon = (ImageIcon) in.readObject();
					messagePanel.add(new JLabel(imageIcon));
					SwingUtilities.updateComponentTreeUI(frame);
				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		arrivedThread.setDaemon(true);
		arrivedThread.start();
	}


	class OverrideMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel label = (JLabel) e.getSource();
			try {
				out.writeObject(label.getIcon());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}
}
