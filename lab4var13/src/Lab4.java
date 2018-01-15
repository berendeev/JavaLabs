import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

public class Lab4 {
	Points hour;
	Points minute;
	private int r;
	private double stepHour;
	private double stepMinute;

	Lab4() {
		stepHour = 0;
		stepMinute = 1;
		r = 150;
		hour = new Points(Math.PI, Math.PI);
		minute = new Points(Math.PI, Math.PI);

		JFrame frame = new JFrame("lab4");
		frame.setSize(new Dimension(640, 480));

		Panel p = new Panel();
		p.setLayout(new BorderLayout());

		Panel panel = new Panel();
		panel.setLayout(new FlowLayout());

		JButton hourPlus = new JButton("Hour +");
		JButton hourMinus = new JButton("Hour -");

		JButton minutePlus = new JButton("Minute +");
		JButton minuteMinus = new JButton("Minute -");

		panel.add(hourPlus);
		panel.add(hourMinus);
		panel.add(minutePlus);
		panel.add(minuteMinus);
		p.add(panel, BorderLayout.NORTH);

		frame.add(p);

		frame.setVisible(true);
		JPanel contentPane = new JPanel() {

			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				draw(g);
			}
		};

		hourPlus.addActionListener(e -> {
			hour.x += Math.PI / 6;
			hour.y += Math.PI / 6;
		});
		hourMinus.addActionListener(e -> {
			hour.x -= Math.PI / 6;
			hour.y -= Math.PI / 6;
		});

		minutePlus.addActionListener(e -> {
			minute.x += Math.PI / 30;
			minute.y += Math.PI / 30;
		});
		minuteMinus.addActionListener(e -> {
			minute.x -= Math.PI / 30;
			minute.y -= Math.PI / 30;
		});

		p.add(contentPane);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		while (true) {
			contentPane.repaint();
		}
	}

	void draw(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.drawOval(100, 100, r * 2, r * 2);

		g2.setColor(Color.RED);
		g2.draw(new Line2D.Double(250, 250, Math.cos(minute.x) * r + 250, Math.sin(minute.y) * r + 250));

		g2.setColor(Color.ORANGE);
		g2.draw(new Line2D.Double(250, 250, Math.cos(hour.x) * r / 2 + 250, Math.sin(hour.y) * r / 2 + 250));

	}

	class Points {
		public double x;
		public double y;

		Points(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

}
