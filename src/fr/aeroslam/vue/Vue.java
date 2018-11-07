package fr.aeroslam.vue;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class Vue extends JFrame {

	public Vue() {
		this.setTitle("AéroSlam");
		this.setSize(600, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
}
