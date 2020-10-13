package fr.unilim.iut.spaceinvaders.model;

import fr.unilim.iut.spaceinvaders.moteurjeu.DessinJeu;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DessinSpaceInvaders implements DessinJeu {

    private SpaceInvaders jeu;

    public DessinSpaceInvaders(SpaceInvaders spaceInvaders) {
        this.jeu = spaceInvaders;
    }

    @Override
    public void dessiner(BufferedImage im) {
        if (!this.jeu.partieFinie()) {
            if (this.jeu.aUnVaisseau()) {
                Vaisseau vaisseau = this.jeu.recupererVaisseau();
                this.dessinerUnVaisseau(vaisseau, im);
            }
            if (this.jeu.aUnEnvahisseur()) {
                Envahisseur envahisseur = this.jeu.recupererEnvahisseur();
                this.dessinerUnEnvahisseur(envahisseur, im);
            }
            if (this.jeu.aUnMissile()) {
                Missile missile = this.jeu.recupererMissile();
                this.dessinerUnMissile(missile, im);
            }
        }
        if (this.jeu.partieFinie()) {
            this.dessinerMessageFin(im);
        }
    }

    private void dessinerUnEnvahisseur(Envahisseur envahisseur, BufferedImage im) {
        Graphics2D crayon = (Graphics2D) im.getGraphics();

        crayon.setColor(Color.red);
        crayon.fillRect(envahisseur.abscisseLaPlusAGauche(), envahisseur.ordonneLaPlusBasse(), envahisseur.longueur(), envahisseur.hauteur());
    }

    private void dessinerUnVaisseau(Vaisseau vaisseau, BufferedImage im) {
        Graphics2D crayon = (Graphics2D) im.getGraphics();

        crayon.setColor(Color.gray);
        crayon.fillRect(vaisseau.abscisseLaPlusAGauche(), vaisseau.ordonneLaPlusBasse(), vaisseau.longueur(), vaisseau.hauteur());

    }

    private void dessinerUnMissile(Missile missile, BufferedImage im) {
        Graphics2D crayon = (Graphics2D) im.getGraphics();

        crayon.setColor(Color.blue);
        crayon.fillRect(missile.abscisseLaPlusAGauche(), missile.ordonneLaPlusBasse(), missile.longueur(), missile.hauteur());

    }

    private void dessinerMessageFin(BufferedImage im) {
        Graphics2D crayon = (Graphics2D) im.getGraphics();

        crayon.setColor(Color.black);
        crayon.fillRect(5, 5, 10, 5);
    }

}
