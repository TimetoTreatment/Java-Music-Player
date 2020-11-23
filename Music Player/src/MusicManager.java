import java.awt.image.BufferedImage;
import java.io.File;
import javafx.embed.swing.JFXPanel;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.embed.swing.SwingFXUtils;

public class MusicManager {

	private static boolean isInitialized = false;
	private Media music;
	private MediaPlayer musicPlayer;

	MusicManager() {
		if (isInitialized == false) {
			new JFXPanel();
			isInitialized = true;
		}
	}

	void Open(String fileName) {

		String path = "file:/" + new File("").getAbsolutePath() + "/Assets/Audio/" + fileName;

		path = path.replace(" ", "%20");
		path = path.replace("\\", "/");

		music = new Media(path);
		musicPlayer = new MediaPlayer(music);
		musicPlayer.setVolume(0.2);
		musicPlayer.play();
	}

	boolean IsPlaying() {
		return musicPlayer.getStatus() == MediaPlayer.Status.PLAYING ? true : false;
	}

	void Play() {
		musicPlayer.play();
	}

	void Pause() {
		musicPlayer.pause();
	}

	void Seek(double position) {
		musicPlayer.seek(musicPlayer.getMedia().getDuration().multiply(position));
	}

	double GetCurrentPosition() {
		return musicPlayer.getCurrentTime().toSeconds() / music.getDuration().toSeconds();
	}

	BufferedImage GetAlbumCover() {
		Image albumCover = (Image) music.getMetadata().get("image");
		return albumCover == null ? null : SwingFXUtils.fromFXImage(albumCover, null);
	}

	String GetTitle() {
		String title = (String) music.getMetadata().get("title");
		return title == null ? "Music Title" : title;
	}

	String GetArtist() {
		String artist = (String) music.getMetadata().get("artist");
		return artist == null ? "Music Artist" : artist;
	}

	String GetAlbum() {
		String album = (String) music.getMetadata().get("album");
		return album == null ? "Album" : album;
	}

}
