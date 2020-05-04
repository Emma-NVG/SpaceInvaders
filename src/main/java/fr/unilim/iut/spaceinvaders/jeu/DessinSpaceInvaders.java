package fr.unilim.iut.spaceinvaders.jeu;

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
        if (this.jeu.aUnVaisseau()) {
            Vaisseau vaisseau = this.jeu.recupererVaisseau();
            Missile missile = this.jeu.recupererMissile();
            this.dessinerUnVaisseau(vaisseau, im);
            if (this.jeu.aUnMissile()) {
                this.dessinerUnMissile(missile, im);
            }
        }
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

}
