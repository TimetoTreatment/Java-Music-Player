import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MusicPlayer extends JFrame {

	JPanel[] allPanel;
	JPanel detailPanel;
	JPanel controlPanel;
	JPanel listPanel;

	private final int detailPanelHeight = 150;
	private final int controlPanelHeight = 100;
	private final int listPanelHeight = 350;

	MusicPlayer() {
		setTitle("Java Music Player");
		setMinimumSize(new Dimension(400, controlPanelHeight + 38));
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		getContentPane().setBackground(Color.black);

		detailPanel = new JPanel();
		controlPanel = new JPanel();
		listPanel = new JPanel();

		allPanel = new JPanel[3];
		allPanel[0] = detailPanel;
		allPanel[1] = controlPanel;
		allPanel[2] = listPanel;
		
		for(var panel : allPanel)
			panel.setBackground(Color.white);

		detailPanel.setPreferredSize(new Dimension(800, detailPanelHeight));
		controlPanel.setPreferredSize(new Dimension(800, controlPanelHeight));
		listPanel.setPreferredSize(new Dimension(800, listPanelHeight));

		controlPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
		
		add(detailPanel);
		add(controlPanel);
		add(listPanel);
		
//		JSlider js = new JSlider();
//
//		js.setEnabled(false);
//		js.setValue(30);
//		
//		controlPanel.add(js);

		addComponentListener(new ComponentAdapter() {

			@Override
			public void componentResized(ComponentEvent e) {
				
				int contentPaneWidth = getContentPane().getWidth();
				int contentPaneHeight = getContentPane().getHeight();

				controlPanel.setMinimumSize(new Dimension(contentPaneWidth, controlPanelHeight));
				controlPanel.setMaximumSize(new Dimension(contentPaneWidth, controlPanelHeight));
				
				if (contentPaneHeight >= detailPanelHeight + controlPanelHeight || listPanel.getHeight() > 10) {
					detailPanel.setMinimumSize(new Dimension(contentPaneWidth, detailPanelHeight));
					detailPanel.setMaximumSize(new Dimension(contentPaneWidth, detailPanelHeight));
					detailPanel.setPreferredSize(new Dimension(contentPaneWidth, detailPanelHeight));
				} else {
					detailPanel.setMinimumSize(new Dimension(contentPaneWidth, contentPaneHeight - controlPanelHeight));
					detailPanel.setMaximumSize(new Dimension(contentPaneWidth, contentPaneHeight - controlPanelHeight));
					detailPanel.setPreferredSize(new Dimension(contentPaneWidth, contentPaneHeight - controlPanelHeight));
				}
			}
		});

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new MusicPlayer();
		});
	}
}
