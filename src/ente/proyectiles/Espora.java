package ente.proyectiles;

import java.awt.Point;
import java.util.Properties;

import ente.grafico.EnteGrafico;
import ente.zombi.visitor.Visitor;

/**
 * The Class Espora.
 */
public class Espora extends Proyectil {
	private int distancia;
	
	/**
	 * Instantiates a new espora.
	 * @param punto the punto
	 * @param p de Properites
	 */
	public Espora(Point position, Properties p) {
		this.setLocation(position);
		this.config = p;		
		this.choqueZombie = false;
		this.width = Integer.parseInt(config.getProperty("ancho_espora"));
		this.height = Integer.parseInt(config.getProperty("alto_espora"));
		this.danio = Integer.parseInt(config.getProperty("danio_espora"));
		this.velocidad = Integer.parseInt(config.getProperty("velocidad_espora"));
		this.distancia = 100*Integer.parseInt(config.getProperty("distancia_espora"));
		this.grafico = new EnteGrafico(this.getLocation(), this.width, this.height, config.getProperty("skin_espora"));
	}

	/**
	 * Accept.
	 * @param v the v
	 */
	public void accept(Visitor v) {
		v.visitProyectil(this);
	}

	public void actualizar() {
		super.actualizar();
		distancia--;
	}
	
	public boolean condicionElim(int lim) {
		return distancia == 0 || super.condicionElim(lim);
	}
	
	/**
	 * Gets the distancia.
	 * @return Distancia a la que llega la espora.
	 */
	public int getDistancia() {
		return this.distancia;
	}
}
