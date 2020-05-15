package fr.unilim.iut.spaceinvaders.model;

public class Envahisseur extends Sprite {

    private boolean sensDeplacementEstVersLaDroite;

    public Envahisseur(Position positionOrigine, Dimension dimension, int vitesse) {
        super(positionOrigine, dimension, vitesse);
    }

    public boolean sensDeplacementEstVersLaDroite() {
        return this.sensDeplacementEstVersLaDroite;
    }

    public void mettreSensDeplacementVersLaDroite(boolean versLaDroite) {
        this.sensDeplacementEstVersLaDroite = versLaDroite;
    }
}
