package jardin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.GUI;

public class JardinGrafico extends JPanel  {
	private GUI gui;
	private JPanel panelGrafico;
	private Properties config;
	private LinkedList<JLabel> entes;
	
	public JardinGrafico(GUI gui) {
		entes = new LinkedList<JLabel>();
		this.gui = gui;
		config = new Properties();
		try {
			FileReader reader=new FileReader("assets/configuracion/panelGrafico.properties");
			config.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		panelGrafico = new JPanel(null);
		panelGrafico.setBounds(10, 10, Integer.parseInt(config.getProperty("width")), Integer.parseInt(config.getProperty("heigth")));
		panelGrafico.setOpaque(false);
		panelGrafico.setLayout(null);
		gui.addJPanel(panelGrafico);
	}
	
	public void removeEnte(JLabel e) {
		if(entes.remove(e)) {
			panelGrafico.remove(e);
			rePaint();
		}
	}
	
	public void setEnte(JLabel e) {
		entes.add(e);
		panelGrafico.add(e);
		rePaint();
	}
	
	public void rePaint() {
		panelGrafico.repaint();
	}
}
