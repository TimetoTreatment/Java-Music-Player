import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class DetailPanel extends JPanel {

	int initialHeight = 150;

	void Model() {

	}

	void View() {

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setPreferredSize(new Dimension(800, initialHeight));
		setBackground(Color.white);

		JPanel musicCover = new JPanel() {
			@Override
			public void paintComponent(Graphics _g) {
				super.paintComponent(_g);

				Graphics2D g = (Graphics2D) _g;

				Image image = new ImageIcon("defaultAlbumCover.png").getImage();

				int imageWidth = (initialHeight - 40) * image.getWidth(this) / image.getHeight(this);
				int padding = 20;

				setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(20, 20, 20, 20),
						new LineBorder(Color.black, 1)));

				g.drawImage(image, (150 - imageWidth) / 2, padding, (150 + imageWidth) / 2, getHeight() - padding, 0, 0,
						image.getWidth(this),
						image.getHeight(this) * (getHeight() - padding * 2) / (initialHeight - padding * 2), this);
			}
		};

		musicCover.setBackground(Color.white);
		musicCover.setMinimumSize(new Dimension(initialHeight, initialHeight));
		musicCover.setMaximumSize(new Dimension(initialHeight, initialHeight));
		musicCover.setPreferredSize(new Dimension(initialHeight, initialHeight));

		JPanel musicDetail = new JPanel();
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				musicDetail.setSize(new Dimension(e.getComponent().getWidth()-musicCover.getWidth(), initialHeight));
			}
		});

		
		JLabel musicName = new JLabel("Music Name");
		JLabel musicAuthor = new JLabel("Music Artist");
		JLabel albumName = new JLabel("Album Name");

		musicName.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
		
		
		musicAuthor.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
		albumName.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
		
		musicName.setBorder(new EmptyBorder(0,10,0,0));

		albumName.setHorizontalAlignment(JLabel.RIGHT);

		musicDetail.setLayout(new BoxLayout(musicDetail, BoxLayout.Y_AXIS));


		musicDetail.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				
				musicName.setMinimumSize(new Dimension(e.getComponent().getWidth(), 50));
				musicName.setMaximumSize(new Dimension(e.getComponent().getWidth(), 50));
				musicName.setPreferredSize(new Dimension(e.getComponent().getWidth(),50));

				musicAuthor.setMinimumSize(new Dimension(e.getComponent().getWidth(), 50));
				musicAuthor.setMaximumSize(new Dimension(e.getComponent().getWidth(), 50));
				musicAuthor.setPreferredSize(new Dimension(e.getComponent().getWidth(), 50));

				albumName.setMinimumSize(new Dimension(e.getComponent().getWidth(), 50));
				albumName.setMaximumSize(new Dimension(e.getComponent().getWidth(), 50));
				albumName.setPreferredSize(new Dimension(e.getComponent().getWidth(),50));
			}
		});



		musicName.setMinimumSize(new Dimension(650, 50));
		musicName.setMaximumSize(new Dimension(650, 50));
		musicName.setPreferredSize(new Dimension(650, 50));

		musicAuthor.setMinimumSize(new Dimension(650, 50));
		musicAuthor.setMaximumSize(new Dimension(650, 50));
		musicAuthor.setPreferredSize(new Dimension(650, 50));

		albumName.setMinimumSize(new Dimension(650, 50));
		albumName.setMaximumSize(new Dimension(650, 50));
		albumName.setPreferredSize(new Dimension(650, 50));

		musicName.setOpaque(true);
		musicAuthor.setOpaque(true);
		musicName.setBackground(Color.red);
		musicAuthor.setBackground(Color.blue);

		musicDetail.add(musicName);
		musicDetail.add(musicAuthor);
		musicDetail.add(albumName);


		add(musicCover);
		add(musicDetail);
	}

	void Control() {

	}

	DetailPanel() {

		Model();
		View();
		Control();

	}

}
