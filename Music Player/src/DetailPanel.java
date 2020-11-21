import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class DetailPanel extends JPanel {

	final int defaultHeight = 150;

	private JLabel detailMusicName = new JLabel("Seattle Alone");
	private JLabel detailMusicAuthor = new JLabel("∫ºª°∞£ªÁ√·±‚");
	private JLabel detailAlbumName = new JLabel("Album Name");

	void View() {

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setPreferredSize(new Dimension(800, defaultHeight));
		setBackground(Color.white);
		setBorder(new MatteBorder(1, 0, 0, 0, Color.black));

		JPanel albumCover = new JPanel() {
			@Override
			public void paintComponent(Graphics _g) {
				super.paintComponent(_g);

				Graphics2D g = (Graphics2D) _g;
				Image image = new ImageIcon("defaultAlbumCover.png").getImage();

				int padding = 25;
				int imageWidth = (defaultHeight - padding * 2) * image.getWidth(this) / image.getHeight(this);

				setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(padding, padding, padding, padding),
						new LineBorder(Color.black, 1)));

				g.drawImage(image, (defaultHeight - imageWidth) / 2, padding, (defaultHeight + imageWidth) / 2,
						getHeight() - padding, 0, 0, image.getWidth(this),
						image.getHeight(this) * (getHeight() - padding * 2) / (defaultHeight - padding * 2), this);
			}
		};

		albumCover.setBackground(Color.white);
		albumCover.setMinimumSize(new Dimension(defaultHeight, defaultHeight));
		albumCover.setMaximumSize(new Dimension(defaultHeight, defaultHeight));
		albumCover.setPreferredSize(new Dimension(defaultHeight, defaultHeight));

		JPanel musicDetail = new JPanel();

		musicDetail.setLayout(new BoxLayout(musicDetail, BoxLayout.Y_AXIS));
		musicDetail.setBackground(Color.white);
		musicDetail.setBorder(new MatteBorder(0, 1, 0, 0, Color.black));

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				musicDetail.setSize(new Dimension(e.getComponent().getWidth() - albumCover.getWidth(), defaultHeight));
			}
		});

		detailMusicName.setMinimumSize(new Dimension(650, 50));
		detailMusicName.setMaximumSize(new Dimension(650, 50));
		detailMusicName.setPreferredSize(new Dimension(650, 50));
		detailMusicName.setBorder(new EmptyBorder(0, 20, 0, 20));
		detailMusicName.setFont(new Font("Malgun Gothic", Font.BOLD, 32));
		musicDetail.add(detailMusicName);

		detailMusicAuthor.setMinimumSize(new Dimension(650, 50));
		detailMusicAuthor.setMaximumSize(new Dimension(650, 50));
		detailMusicAuthor.setPreferredSize(new Dimension(650, 50));
		detailMusicAuthor.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
		detailMusicAuthor.setBorder(new EmptyBorder(0, 20, 0, 20));
		musicDetail.add(detailMusicAuthor);

		detailAlbumName.setMinimumSize(new Dimension(650, 50));
		detailAlbumName.setMaximumSize(new Dimension(650, 50));
		detailAlbumName.setPreferredSize(new Dimension(650, 50));
		detailAlbumName.setBorder(new EmptyBorder(10, 20, 0, 20));
		detailAlbumName.setFont(new Font("Malgun Gothic", Font.BOLD | Font.ITALIC, 20));
		detailAlbumName.setHorizontalAlignment(JLabel.RIGHT);
		musicDetail.add(detailAlbumName);

		musicDetail.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {

				detailMusicName.setMinimumSize(new Dimension(e.getComponent().getWidth(), 50));
				detailMusicName.setMaximumSize(new Dimension(e.getComponent().getWidth(), 50));
				detailMusicName.setPreferredSize(new Dimension(e.getComponent().getWidth(), 50));

				detailMusicAuthor.setMinimumSize(new Dimension(e.getComponent().getWidth(), 40));
				detailMusicAuthor.setMaximumSize(new Dimension(e.getComponent().getWidth(), 40));
				detailMusicAuthor.setPreferredSize(new Dimension(e.getComponent().getWidth(), 40));

				detailAlbumName.setMinimumSize(new Dimension(e.getComponent().getWidth(), 60));
				detailAlbumName.setMaximumSize(new Dimension(e.getComponent().getWidth(), 60));
				detailAlbumName.setPreferredSize(new Dimension(e.getComponent().getWidth(), 60));
			}
		});

		add(albumCover);
		add(musicDetail);
	}

	class Control {
		void SetMusicName(String musicName) {
			detailMusicName.setText(musicName);
		}

		void SetMusicAuthor(String musicAuthor) {
			detailMusicAuthor.setText(musicAuthor);

		}

		void SetAlbumName(String albumName) {
			detailAlbumName.setText(albumName);
		}

	}

	DetailPanel() {
		if (Config.debug == false) {
			detailMusicName.setOpaque(true);
			detailMusicName.setBackground(Color.red);

			detailMusicAuthor.setOpaque(true);
			detailMusicAuthor.setBackground(Color.green);

			detailAlbumName.setOpaque(true);
			detailAlbumName.setBackground(Color.cyan);
		}

		View();
	}

}
