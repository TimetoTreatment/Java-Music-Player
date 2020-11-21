import java.awt.Color;

public class Config {

	static boolean debug = true;
	static boolean darkMode = false;
	static Color foregroundColor = Color.black;
	static Color backgroundColor = Color.white;

	Config() {

		if (darkMode == true) {
			foregroundColor = Color.white;
			backgroundColor = Color.black;
		} else {
			foregroundColor = Color.black;
			backgroundColor = Color.white;
		}
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
