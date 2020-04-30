package fr.unilim.iut.spaceinvaders.moteurjeu;

import javax.swing.*;


public class InterfaceGraphique {

	private PanelDessin panel;

	private Controleur controleur;

	public InterfaceGraphique(DessinJeu afficheurUtil, int x, int y) {
		//creation JFrame
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// creation panel
		this.panel = new PanelDessin(x, y, afficheurUtil);
		f.setContentPane(this.panel);

		//ajout du controleur
		Controleur controlleurGraph = new Controleur();
		this.controleur = controlleurGraph;
		this.panel.addKeyListener(controlleurGraph);

		//recuperation du focus
		f.pack();
		f.setVisible(true);
		f.getContentPane().setFocusable(true);
		f.getContentPane().requestFocus();
	}


	public Controleur getControleur() {
		return controleur;
	}

	public void dessiner() {
		this.panel.dessinerJeu();
	}

}
