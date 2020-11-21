import java.awt.Color;

public class Config {

	Color foregroundColor = Color.black;
	Color backgroundColor = Color.white;

	Config() {

	}

	void Darkmode(boolean b) {
		if (b == true) {
			foregroundColor = Color.white;
			backgroundColor = Color.black;
		} else {
			foregroundColor = Color.black;
			backgroundColor = Color.white;
		}
	}
}
