import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

public class ControlPanel extends JPanel {

	final static int defaultHeight = 130;

	private int musicPos = 50;
	private int musicLength = 100;
	private double trackBarPos = 50;
	private JPanel trackBar;
	private JPanel controller;

	class Model {

	}

	void View() {
		
		setPreferredSize(new Dimension(800, defaultHeight));
		setBackground(Config.backgroundColor);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new MatteBorder(1, 0, 1, 0, Color.black));

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {

				int controlPanelWidth = e.getComponent().getWidth();

				trackBar.setMinimumSize(new Dimension(controlPanelWidth, 60));
				trackBar.setMaximumSize(new Dimension(controlPanelWidth, 60));
				trackBar.setPreferredSize(new Dimension(controlPanelWidth, 60));
				controller.setMinimumSize(new Dimension(controlPanelWidth, 65));
				controller.setMaximumSize(new Dimension(controlPanelWidth, 65));
				controller.setPreferredSize(new Dimension(controlPanelWidth, 65));
			}
		});

		trackBar = new JPanel() {
			@Override
			public void paintComponent(Graphics _g) {
				super.paintComponent(_g);

				Graphics2D g = (Graphics2D) _g;
				int paddingTopBottom = 20;
				int paddingLeftRight = 50;

				g.setColor(new Color(0xD9D9D9));
				g.fillRect(paddingLeftRight, paddingTopBottom, (int) (getWidth()) - 2 * paddingLeftRight, 20);

				g.setColor(new Color(0, 0, 0));
				g.fillRect(paddingLeftRight, paddingTopBottom,
						(int) (trackBarPos * getWidth() / 100) - 2 * paddingLeftRight, 20);
			}
		};

		trackBar.setBackground(Config.backgroundColor);
		trackBar.setMinimumSize(new Dimension(800, 60));
		trackBar.setMaximumSize(new Dimension(800, 60));
		trackBar.setPreferredSize(new Dimension(800, 60));
		add(trackBar);

		controller = new JPanel();
		
		controller.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));

		//controller.setBackground(Color.red);
		controller.setBackground(Config.backgroundColor);
		controller.setMinimumSize(new Dimension(800, 60));
		controller.setMaximumSize(new Dimension(800, 60));
		controller.setPreferredSize(new Dimension(800, 60));

		JButton prevMusic = new JButton("prev") {
			@Override
			public void paintComponent(Graphics _g) {
				super.paintComponent(_g);

				Graphics2D g = (Graphics2D) _g;

				Image img = new ImageIcon("prev.png").getImage();

				g.drawImage(img, 0, 0, 50, 50, 0, 0, img.getWidth(this), img.getHeight(this), this);
			}
		};

		prevMusic.setBorder(BorderFactory.createEmptyBorder());
		prevMusic.setPreferredSize(new Dimension(50, 50));
		controller.add(prevMusic);

		JButton playMusic = new JButton("play") {
			@Override
			public void paintComponent(Graphics _g) {
				super.paintComponent(_g);

				Graphics2D g = (Graphics2D) _g;

				Image img = new ImageIcon("play.png").getImage();

				g.drawImage(img, 0, 0, 50, 50, 0, 0, img.getWidth(this), img.getHeight(this), this);
			}
		};

		playMusic.setBorder(BorderFactory.createEmptyBorder());
		playMusic.setPreferredSize(new Dimension(50, 50));
		controller.add(playMusic);

		JButton nextMusic = new JButton("next") {
			@Override
			public void paintComponent(Graphics _g) {
				super.paintComponent(_g);

				Graphics2D g = (Graphics2D) _g;

				Image img = new ImageIcon("next.png").getImage();

				g.drawImage(img, 0, 0, 50, 50, 0, 0, img.getWidth(this), img.getHeight(this), this);
			}
		};

		nextMusic.setBorder(BorderFactory.createEmptyBorder());
		nextMusic.setPreferredSize(new Dimension(50, 50));
		controller.add(nextMusic);

		add(controller);
	}

	class Control {
		void SetTrackBar(int pos, int length) {
			musicPos = pos;
			musicLength = length;
			trackBarPos = musicPos * 100 / musicLength;
		}

	}

	ControlPanel() {
		View();
	}

}
