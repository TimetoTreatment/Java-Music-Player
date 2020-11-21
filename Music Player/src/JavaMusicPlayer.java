import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.Scanner;

public class JavaMusicPlayer extends JFrame {

	DetailPanel detailPanel;
	ControlPanel controlPanel;
	ListPanel listPanel;
	
	int minimumHeight = 186 + 39;

	void Model() {

		new Config();


		
	}

	void View() {

		setTitle("Java Music Player");
		setMinimumSize(new Dimension(400, minimumHeight));
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		detailPanel = new DetailPanel();
		controlPanel = new ControlPanel();
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

	void Control() {

	}

	JavaMusicPlayer() {
		Model();
		View();
		Control();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new JavaMusicPlayer();
		});
	}
}
