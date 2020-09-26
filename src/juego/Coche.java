package juego;

import java.awt.Image;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Coche {
	
	private double miVelocidad; // Velocidad en pixels/segundo
	protected double miDireccionActual; // Dirección en la que estoy mirando en grados (de 0 a 360)
	protected double posX; // Posición en X (horizontal)
	protected double posY; // Posición en Y (vertical)
	//private String piloto; // Nombre de piloto
	private double anguloDeGiro;
	private int width;
	private int height;
	private JLabelCoche img;
	private JPanel panel;

	
	public Coche(double miVelocidad, double miDireccionActual, double posX, double posY, double anguloDeGiro, int width,
			int height, JLabelCoche img, JPanel panel) {
		super();
		this.miVelocidad = miVelocidad;
		this.miDireccionActual = miDireccionActual;
		this.posX = posX;
		this.posY = posY;
		this.anguloDeGiro = anguloDeGiro;
		this.width = width;
		this.height = height;
		this.img = img;
		this.panel = panel;
	}

	public Coche(JPanel panel) {
		super();
		this.miVelocidad = 0;
		this.miDireccionActual = 0;
		this.posX = 100;
		this.posY = 100;
		//this.piloto = piloto;
		this.anguloDeGiro = 90;
		this.width = 150;
		this.height = 75;
		this.panel = panel;
		Image image = getScalatedImage();
		ImageIcon icon = new ImageIcon(image);
		img = new JLabelCoche(icon, this);

	}
	
	public double getMiVelocidad() {
		return miVelocidad;
	}

	public void setMiVelocidad(double miVelocidad) {
		this.miVelocidad = miVelocidad;
	}

	public double getMiDireccionActual() {
		return miDireccionActual;
	}

	public void setMiDireccionActual(double miDireccionActual) {
		this.miDireccionActual = miDireccionActual;
	}

	public double getPosX() {
		return (int) this.getPosX();
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return (int) this.getPosY();
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	/*public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}*/
	
	public double getAnguloDeGiro() {
		return anguloDeGiro;
	}
	
	public void setAnguloDeGiro(double anguloDeGiro) {
		this.anguloDeGiro = anguloDeGiro;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public JLabelCoche getImg() {
		return img;
	}

	public void setImg(JLabelCoche img) {
		this.img = img;
	}
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/** Cambia la velocidad actual del coche
	 * @param aceleracion Incremento de la velocidad en pixels/segundo
	 */
	 public void acelera() {
		 this.miVelocidad = this.miVelocidad + 1;
	 }
	 
	 public void frena() {
		 if(miVelocidad >= 1) {
			this.miVelocidad = this.miVelocidad - 1;
		 }	
	 }
	 
	 /** Cambia la dirección actual del coche
	 * @param giro Angulo de giro a sumar o restar de la dirección actual, en grados (-180 a +180)
	 */
	 
	 public void giraIzq() {
		 this.anguloDeGiro = this.anguloDeGiro + 5;
		 metodoAngulos();
	 }
	 
	 public void giraDer() {
		 this.anguloDeGiro = this.anguloDeGiro - 5;
		 metodoAngulos();
	 }
	 
	 private void metodoAngulos() {
		 if(this.anguloDeGiro >=360) {
			 this.anguloDeGiro = this.anguloDeGiro - 360;
		 }
		 if(this.anguloDeGiro < 0) {
			 this.anguloDeGiro = this.anguloDeGiro + 360;
		 }
	 }
	 
	/** Cambia la posición del coche dependiendo de su velocidad y dirección
	 * @param tiempoDeMovimiento Tiempo transcurrido, en segundos
	 */
	 
	public void mueve() {
		double nuevoX, nuevoY;
		nuevoX = miVelocidad*Math.sin(Math.PI*anguloDeGiro/180);
		nuevoY = miVelocidad*Math.cos(Math.PI*anguloDeGiro/180);
		this.posX = this.posX + nuevoX;
		this.posY = this.posY + nuevoY;
		img.setBounds((int) posX,(int) posY, width, width);
	} 
	 
	private Image getScalatedImage() {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("a.png"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return dimg;
	}

	@Override
	public String toString() {
		return "Coche [miVelocidad=" + miVelocidad + ", miDireccionActual=" + miDireccionActual + ", posX=" + posX
				+ ", posY=" + posY + ", anguloDeGiro=" + anguloDeGiro + ", width=" + width
				+ ", height=" + height + ", img=" + img + ", panel=" + panel + "]";
	}
	 
}
