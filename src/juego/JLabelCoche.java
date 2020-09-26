package juego;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelCoche extends JLabel {

	private static final long serialVersionUID = 1L;
	private Coche coche;
	
	public JLabelCoche(ImageIcon m, Coche coche) {
		super(m);
		this.coche = coche;
	}
	
	public void paintComponent(Graphics gr) {
		Graphics2D g = (Graphics2D) gr;
		g.rotate(-Math.PI*(coche.getAnguloDeGiro()-90)/180, this.getWidth()/2, this.getHeight()/2);
		super.paintComponent(gr);
	}
}
