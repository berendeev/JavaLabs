import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Lab4 {
	private int w;
	private int q;
	private int t;
	private boolean isActive;

	Lab4(int q, int w) {
		isActive = true;
		t = 0;
		this.q = q;
		this.w = w;

		JFrame mainWindow = new JFrame("lab4");
		mainWindow.setSize(new Dimension(600, 280));

		Panel p = new Panel();
		p.setLayout(new BorderLayout());

		Panel settings = new Panel();
		settings.setLayout(new FlowLayout());

		JButton active = new JButton("Start/Stop");
		active.addActionListener(e -> isActive = !isActive);

		JLabel lbl_q = new JLabel("q");
		JTextField tf_q = new JTextField("100");
		tf_q.setPreferredSize(new Dimension(50, tf_q.getPreferredSize().height));

		JLabel lbl_w = new JLabel("w");
		JTextField tf_w = new JTextField("2");
		tf_w.setPreferredSize(new Dimension(50, tf_w.getPreferredSize().height));

		tf_q.addActionListener(e -> changeQ(Integer.parseInt(tf_q.getText())));
		tf_w.addActionListener(e -> changeW(Integer.parseInt(tf_w.getText())));

		settings.add(active);
		settings.add(lbl_q);
		settings.add(tf_q);
		settings.add(lbl_w);
		settings.add(tf_w);
		p.add(settings, BorderLayout.NORTH);

		mainWindow.add(p);

		mainWindow.setVisible(true);
		JPanel contentPane = new JPanel() {

			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				draw(g);
			}
		};
		p.add(contentPane);
		mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		while (true) {
			contentPane.repaint();
			if (isActive) {
				t += 10;
			}
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.BLACK);
		for (int x = 0; x < q; x++) {
//			g.drawLine(x, func(t), x + 10, func(t + 10));

//			g.drawLine(x * 3, func(x + t), (x + 1) * 3, func(x + 1 + t));
			g2.draw(new Line2D.Double(x * 3, func(x + t), (x + 1) * 3, func(x + 1 + t)));
		}
	}

	private double func(int t) {
		return (q * (1 + Math.cos(w * t)) / 2);
	}

	private void changeQ(int value) {
		q = value;
	}

	private void changeW(int value) {
		w = value;
	}
}
