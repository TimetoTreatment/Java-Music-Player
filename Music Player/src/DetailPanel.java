import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class DetailPanel extends JPanel {

	final int defaultHeight = 150;

	private MusicManager musicManager;
	private Image albumCoverImage = new ImageIcon("defaultAlbumCover.png").getImage();
	private JLabel detailMusicTitle = new JLabel("Music Name");
	private JLabel detailMusicArtist = new JLabel("Music Author");
	private JLabel detailAlbumName = new JLabel("Album Name");

	void Draw() {

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setPreferredSize(new Dimension(800, defaultHeight));
		setBackground(Color.white);
		setBorder(new MatteBorder(1, 0, 0, 0, Color.black));

		JPanel albumCover = new JPanel() {
			@Override
			public void paintComponent(Graphics _g) {
				super.paintComponent(_g);

				Graphics2D g = (Graphics2D) _g;

				albumCoverImage = musicManager.GetAlbumCover();

				if (albumCoverImage == null)
					albumCoverImage = new ImageIcon("defaultAlbumCover.png").getImage();

				int padding = 30;
				int imageWidth = (defaultHeight - padding * 2) * albumCoverImage.getWidth(this)
						/ albumCoverImage.getHeight(this);

				setBorder(new CompoundBorder(new EmptyBorder(padding, padding, padding, padding),
						new LineBorder(Color.black, 1)));

				g.drawImage(albumCoverImage, (defaultHeight - imageWidth) / 2, padding,
						(defaultHeight + imageWidth) / 2, getHeight() - padding, 0, 0, albumCoverImage.getWidth(this),
						albumCoverImage.getHeight(this) * (getHeight() - padding * 2) / (defaultHeight - padding * 2),
						this);
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

		detailMusicTitle.setMinimumSize(new Dimension(650, 50));
		detailMusicTitle.setMaximumSize(new Dimension(650, 50));
		detailMusicTitle.setPreferredSize(new Dimension(650, 50));
		detailMusicTitle.setBorder(new EmptyBorder(0, 20, 0, 20));
		detailMusicTitle.setFont(new Font("Malgun Gothic", Font.BOLD, 36));
		musicDetail.add(detailMusicTitle);

		detailMusicArtist.setMinimumSize(new Dimension(650, 50));
		detailMusicArtist.setMaximumSize(new Dimension(650, 50));
		detailMusicArtist.setPreferredSize(new Dimension(650, 50));
		detailMusicArtist.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
		detailMusicArtist.setBorder(new EmptyBorder(0, 20, 0, 20));
		musicDetail.add(detailMusicArtist);

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

				detailMusicTitle.setMinimumSize(new Dimension(e.getComponent().getWidth(), 50));
				detailMusicTitle.setMaximumSize(new Dimension(e.getComponent().getWidth(), 50));
				detailMusicTitle.setPreferredSize(new Dimension(e.getComponent().getWidth(), 50));

				detailMusicArtist.setMinimumSize(new Dimension(e.getComponent().getWidth(), 40));
				detailMusicArtist.setMaximumSize(new Dimension(e.getComponent().getWidth(), 40));
				detailMusicArtist.setPreferredSize(new Dimension(e.getComponent().getWidth(), 40));

				detailAlbumName.setMinimumSize(new Dimension(e.getComponent().getWidth(), 60));
				detailAlbumName.setMaximumSize(new Dimension(e.getComponent().getWidth(), 60));
				detailAlbumName.setPreferredSize(new Dimension(e.getComponent().getWidth(), 60));
			}
		});

		add(albumCover);
		add(musicDetail);
	}

	void SetAlbumCover(String filename) {
		albumCoverImage = new ImageIcon(filename).getImage();
	}

	void SetTitle(String title) {
		detailMusicTitle.setText(title);
	}

	void SetArtist(String artist) {
		detailMusicArtist.setText(artist);
	}

	void SetAlbum(String album) {
		detailAlbumName.setText(album);
	}

	DetailPanel(MusicManager _musicManager) {

		musicManager = _musicManager;

		if (Config.debug == false) {

			detailMusicTitle.setOpaque(true);
			detailMusicTitle.setBackground(Color.red);

			detailMusicArtist.setOpaque(true);
			detailMusicArtist.setBackground(Color.green);

			detailAlbumName.setOpaque(true);
			detailAlbumName.setBackground(Color.cyan);
		}

		Draw();
	}

}
