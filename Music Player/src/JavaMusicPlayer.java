import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JavaMusicPlayer extends JFrame {

	private MusicManager musicManager;
	private DetailPanel detailPanel;
	private ControlPanel controlPanel;
	private ListPanel listPanel;

	final int minimumHeight = 186 + 39;

	JavaMusicPlayer() {

		new Config();

		musicManager = new MusicManager();
		musicManager.Open("s.mp3");

		View();
		Update();
	}

	void View() {

		setTitle("Java Music Player");
		setMinimumSize(new Dimension(400, minimumHeight));
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		detailPanel = new DetailPanel(musicManager);
		controlPanel = new ControlPanel(musicManager);
		listPanel = new ListPanel();

		add(detailPanel);
		add(controlPanel);
		add(listPanel);

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {

				int contentPaneWidth = getContentPane().getWidth();
				int contentPaneHeight = getContentPane().getHeight();

				controlPanel.setMinimumSize(new Dimension(contentPaneWidth, ControlPanel.defaultHeight));
				controlPanel.setMaximumSize(new Dimension(contentPaneWidth, ControlPanel.defaultHeight));

				if (contentPaneHeight >= detailPanel.defaultHeight + ControlPanel.defaultHeight
						|| listPanel.getHeight() > 10) {
					detailPanel.setMinimumSize(new Dimension(contentPaneWidth, detailPanel.defaultHeight));
					detailPanel.setMaximumSize(new Dimension(contentPaneWidth, detailPanel.defaultHeight));
					detailPanel.setPreferredSize(new Dimension(contentPaneWidth, detailPanel.defaultHeight));
				} else {
					detailPanel.setMinimumSize(
							new Dimension(contentPaneWidth, contentPaneHeight - ControlPanel.defaultHeight));
					detailPanel.setMaximumSize(
							new Dimension(contentPaneWidth, contentPaneHeight - ControlPanel.defaultHeight));
					detailPanel.setPreferredSize(
							new Dimension(contentPaneWidth, contentPaneHeight - ControlPanel.defaultHeight));
				}
			}
		});

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	void Update() {
		new Thread(() -> {
			for (;;) {
				detailPanel.SetTitle(musicManager.GetTitle());
				detailPanel.SetArtist(musicManager.GetArtist());
				detailPanel.SetAlbum(musicManager.GetAlbum());
			}
		}).start();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new JavaMusicPlayer();
		});
	}
}
