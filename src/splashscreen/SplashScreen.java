package splashscreen;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class SplashScreen extends JWindow {
	protected int tiempo;
	
	/*
	 * Crear una SplashScreen, con tiempo en segundos
	 */
	public SplashScreen(int tiempo, String url) {
		this.tiempo = tiempo;
		JPanel panel = (JPanel) getContentPane();
		ImageIcon img 	= new ImageIcon(url);
		
		panel.add(new JLabel(img), BorderLayout.CENTER);
		setSize(img.getIconWidth(), img.getIconHeight());
		setLocationRelativeTo(null);
		setVisible(true);
		
		try {
			Thread.sleep(tiempo*1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		setVisible(false);		
	}
}
