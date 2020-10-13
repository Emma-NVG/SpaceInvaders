package fr.unilim.iut.spaceinvaders.model;

public abstract class Sprite {
    protected Position origine;
    protected Dimension dimension;
    protected int vitesse;

    public Sprite() {
    }

    public Sprite(Position positionOrigine, Dimension dimension, int vitesse) {
        super();
        this.origine = positionOrigine;
        this.dimension = dimension;
        this.vitesse = vitesse;
    }

    public boolean occupeLaPosition(int x, int y) {
        return (estAbscisseCouverte(x) && estOrdonneeCouverte(y));
    }

    private boolean estOrdonneeCouverte(int y) {
        return (ordonneLaPlusBasse() <= y) && (y <= ordonneLaPlusHaute());
    }

    private boolean estAbscisseCouverte(int x) {
        return (abscisseLaPlusAGauche() <= x) && (x <= abscisseLaPlusADroite());
    }

    public int ordonneLaPlusHaute() {
        return this.origine.ordonnee();
    }

    public int ordonneLaPlusBasse() {
        return this.origine.ordonnee() - this.dimension.hauteur() + 1;
    }

    public int abscisseLaPlusADroite() {
        return this.origine.abscisse() + this.dimension.longueur() - 1;
    }

    public int abscisseLaPlusAGauche() {
        return this.origine.abscisse();
    }

    public void deplacerHorizontalementVers(Direction direction) {
        this.origine.changerAbscisse(this.origine.abscisse() + direction.valeur() * vitesse);
    }

    public void deplacerVerticalementVers(Direction direction) {
        this.origine.changerOrdonnee(this.origine.ordonnee() + direction.valeur() * vitesse);
    }

    public void positionner(int x, int y) {
        this.origine.changerAbscisse(x);
        this.origine.changerOrdonnee(y);
    }

    public int hauteur() {
        return this.dimension.hauteur();
    }

    public int longueur() {
        return this.dimension.longueur();
    }

}
