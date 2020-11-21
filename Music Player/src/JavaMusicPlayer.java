import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JavaMusicPlayer extends JFrame {

	DetailPanel detailPanel;
	ControlPanel controlPanel;
	ListPanel listPanel;
	
	void Model() {
		
		
		
	}
	
	
	
	void View() {
		
		setTitle("Java Music Player");
		setMinimumSize(new Dimension(400, controlPanel.initialHeight + 38));
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().setBackground(Color.black);
		
		add(detailPanel);
		add(controlPanel);
		add(listPanel);

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				
				int contentPaneWidth = getContentPane().getWidth();
				int contentPaneinitialHeight = getContentPane().getHeight();
				
				controlPanel.setMinimumSize(new Dimension(contentPaneWidth, controlPanel.initialHeight));
				controlPanel.setMaximumSize(new Dimension(contentPaneWidth, controlPanel.initialHeight));
				
				if (contentPaneinitialHeight >= detailPanel.initialHeight + controlPanel.initialHeight || listPanel.getHeight() > 10) {
					detailPanel.setMinimumSize(new Dimension(contentPaneWidth, detailPanel.initialHeight ));
					detailPanel.setMaximumSize(new Dimension(contentPaneWidth, detailPanel.initialHeight ));
					detailPanel.setPreferredSize(new Dimension(contentPaneWidth, detailPanel.initialHeight ));
				} else {
					detailPanel.setMinimumSize(new Dimension(contentPaneWidth, contentPaneinitialHeight - controlPanel.initialHeight));
					detailPanel.setMaximumSize(new Dimension(contentPaneWidth, contentPaneinitialHeight - controlPanel.initialHeight));
					detailPanel.setPreferredSize(new Dimension(contentPaneWidth, contentPaneinitialHeight - controlPanel.initialHeight));
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
		
		detailPanel = new DetailPanel();
		controlPanel = new ControlPanel();
		listPanel = new ListPanel();
		
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
