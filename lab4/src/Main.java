import javax.swing.*;
import java.awt.*;

public class Main {
	public static void main(String[] args) {
	run();
	}

	public static void run() {
		JFrame mainWindow = new JFrame("lab4");
		mainWindow.setSize(new Dimension(300,300));
		mainWindow.setResizable(false);
		mainWindow.setVisible(true);


		JPanel contentPane = new JPanel(){
			Graphics2D g2;

			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				g2=(Graphics2D)g;
				g2.setColor(Color.BLACK);
				g2.drawLine(20, 20, 360, 20);
			}
		};
		mainWindow.setContentPane(contentPane);
		mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
