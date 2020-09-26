package juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaJuego extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static Coche coche;
	
	
	public static void main(String[] args) {
		Ventana ventana = new Ventana();
		ventana.setVisible(true);
	}
	static class Ventana extends JFrame {
		
		private static final long serialVersionUID = 1L;
		private JButton btnAcelera;
		private JButton btnFrena;
		private JButton btnGiraIzq;
		private JButton btnGiraDer;

		Ventana() {
			Container cp = getContentPane();
			
			//JPanel
			JPanel panelBlanco = new JPanel();
			panelBlanco.setLayout(new BorderLayout());
			panelBlanco.setBackground(Color.WHITE);
			cp.add(panelBlanco, BorderLayout.CENTER);
			
			coche = new Coche(panelBlanco);
			JLabel imagen = coche.getImg();
			panelBlanco.add(imagen);
			imagen.setSize(coche.getWidth(),coche.getHeight());
			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
			setSize(800, 700);
			setTitle("Juego coche");
			setLocation(250, 20);

			Thread MiHilo = new Thread() {
				@Override
				public void run() {
					super.run();
					while(true) {
						coche.mueve();
						try {
						Thread.sleep(40);
						} catch(Exception e) {}
					}
				}
			};
			MiHilo.start();
			
		//Botones
			
		btnAcelera = new JButton("Acelera");
		btnFrena = new JButton("Frena");
		btnGiraIzq = new JButton("Gira Izq.");
		btnGiraDer = new JButton("Gira Der.");

		JPanel panelBotones = new JPanel(new FlowLayout());
		cp.add(panelBotones, BorderLayout.SOUTH);
		panelBotones.add(btnAcelera);
		panelBotones.add(btnFrena);
		panelBotones.add(btnGiraIzq);
		panelBotones.add(btnGiraDer);
			
		btnAcelera.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				coche.acelera();
			}
		});
			
		btnFrena.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				coche.frena();
			}
		});
			
		btnGiraIzq.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				coche.giraIzq();
			}
		});
			
		btnGiraDer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				coche.giraDer();
			}
		});
			
		}

	}
	
}
