package fr.unilim.iut.spaceinvaders.model;

import fr.unilim.iut.spaceinvaders.moteurjeu.Commande;
import fr.unilim.iut.spaceinvaders.moteurjeu.Jeu;
import fr.unilim.iut.spaceinvaders.utils.DebordementEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.HorsEspaceJeuException;
import fr.unilim.iut.spaceinvaders.utils.MissileException;

public class SpaceInvaders implements Jeu {
    int longueur;
    int hauteur;
    Vaisseau vaisseau;
    Missile missile;
    Envahisseur envahisseur;

    public SpaceInvaders(int longueur, int hauteur) {
        this.longueur = longueur;
        this.hauteur = hauteur;
    }

    public void initialiserJeu() {
        Position positionVaisseau = new Position(this.longueur / 2, this.hauteur - 1);
        Dimension dimensionVaisseau = new Dimension(Constante.VAISSEAU_LONGUEUR, Constante.VAISSEAU_HAUTEUR);
        positionnerUnNouveauVaisseau(dimensionVaisseau, positionVaisseau, Constante.VAISSEAU_VITESSE);

        Position positionEnvahisseur = new Position(this.longueur / 2, 12);
        Dimension dimensionEnvahisseur = new Dimension(Constante.ENVAHISSEUR_LONGUEUR, Constante.ENVAHISSEUR_HAUTEUR);
        positionnerUnNouvelEnvahisseur(dimensionEnvahisseur, positionEnvahisseur, Constante.ENVAHISSEUR_VITESSE);
    }

    private boolean estDansEspaceJeu(int x, int y) {
        return ((x >= 0) && (x < longueur)) && ((y >= 0) && (y < hauteur));
    }

    public String recupererEspaceJeuDansChaineASCII() {
        StringBuilder espaceDeJeu = new StringBuilder();
        for (int y = 0; y < hauteur; y++) {
            for (int x = 0; x < longueur; x++) {
                espaceDeJeu.append(recupererMarqueDeLaPosition(x, y));
            }
            espaceDeJeu.append(Constante.MARQUE_FIN_LIGNE);
        }
        return espaceDeJeu.toString();
    }

    private char recupererMarqueDeLaPosition(int x, int y) {
        char marque;
        if (this.aUnVaisseauQuiOccupeLaPosition(x, y))
            marque = Constante.MARQUE_VAISSEAU;
        else if (this.aUnMissileQuiOccupeLaPosition(x, y))
            marque = Constante.MARQUE_MISSILE;
        else if (this.aUnEnvahisseurQuiOccupeLaPosition(x, y))
            marque = Constante.MARQUE_ENVAHISSEUR;
        else marque = Constante.MARQUE_VIDE;
        return marque;
    }

    private boolean aUnEnvahisseurQuiOccupeLaPosition(int x, int y) {
        return this.aUnEnvahisseur() && envahisseur.occupeLaPosition(x, y);
    }

    private boolean aUnEnvahisseur() {
        return envahisseur != null;
    }

    private boolean aUnMissileQuiOccupeLaPosition(int x, int y) {
        return this.aUnMissile() && missile.occupeLaPosition(x, y);
    }

    public boolean aUnMissile() {
        return missile != null;
    }

    private boolean aUnVaisseauQuiOccupeLaPosition(int x, int y) {
        return this.aUnVaisseau() && vaisseau.occupeLaPosition(x, y);
    }

    public boolean aUnVaisseau() {
        return vaisseau != null;
    }

    public void deplacerVaisseauVersLaDroite() {
        if (vaisseauPasSurLeBordDroitDeLEspaceDeJeu()) {
            vaisseau.deplacerHorizontalementVers(Direction.DROITE);
            if (!estDansEspaceJeu(vaisseau.abscisseLaPlusADroite(), vaisseau.ordonneLaPlusHaute())) {
                vaisseau.positionner(longueur - vaisseau.longueur(), vaisseau.ordonneLaPlusHaute());
            }
        }
    }

    public void deplacerVaisseauVersLaGauche() {
        if (vaisseauPasSurLeBordGaucheDeLEspaceDeJeu())
            vaisseau.deplacerHorizontalementVers(Direction.GAUCHE);
        if (!estDansEspaceJeu(vaisseau.abscisseLaPlusAGauche(), vaisseau.ordonneLaPlusHaute())) {
            vaisseau.positionner(0, vaisseau.ordonneLaPlusHaute());
        }
    }

    private boolean vaisseauPasSurLeBordDroitDeLEspaceDeJeu() {
        return vaisseau.abscisseLaPlusADroite() < (longueur - 1);
    }

    private boolean vaisseauPasSurLeBordGaucheDeLEspaceDeJeu() {
        return vaisseau.abscisseLaPlusAGauche() > 0;
    }

    public void positionnerUnNouveauVaisseau(Dimension dimension, Position position, int vitesse) {
        positionValide(dimension, position, "La position du vaisseau est en dehors de l'espace jeu", "Le vaisseau déborde de l'espace jeu vers la droite à cause de sa longueur", "Le vaisseau déborde de l'espace jeu vers le bas à cause de sa hauteur");
        vaisseau = new Vaisseau(dimension, position, vitesse);
    }

    public Vaisseau recupererVaisseau() {
        return this.vaisseau;
    }

    @Override
    public void evoluer(Commande commande) {
        if (commande.gauche) {
            this.deplacerVaisseauVersLaGauche();
        }
        if (commande.droite) {
            this.deplacerVaisseauVersLaDroite();
        }
        if (commande.tir && !this.aUnMissile()) {
            tirerUnMissile(new Dimension(Constante.MISSILE_LONGUEUR, Constante.MISSILE_HAUTEUR), Constante.MISSILE_VITESSE);
        }
        if (this.aUnMissile()) {
            deplacerMissile();
        }
        if (this.aUnEnvahisseur()) {
            deplacerEnvahisseur();
        }
    }

    @Override
    public boolean etreFini() {
        return false;
    }

    public void tirerUnMissile(Dimension dimensionMissile, int vitesseMissile) {

        if ((vaisseau.hauteur() + dimensionMissile.hauteur()) > this.hauteur)
            throw new MissileException("Pas assez de hauteur libre entre le vaisseau et le haut de l'espace jeu pour tirer le missile");
        this.missile = this.vaisseau.tirerUnMissile(dimensionMissile, vitesseMissile);
    }

    public Missile recupererMissile() {
        return this.missile;
    }

    public void deplacerMissile() {
        if (missile.ordonneLaPlusBasse() <= 0)
            missile = null;
        else
            missile.deplacerVerticalementVers(Direction.HAUT_ECRAN);
    }

    public void positionnerUnNouvelEnvahisseur(Dimension dimension, Position position, int vitesse) {
        positionValide(dimension, position, "La position de l'envahisseur est en dehors de l'espace jeu", "L'envahisseur déborde de l'espace jeu vers la droite à cause de sa longueur", "L'envahisseur déborde de l'espace jeu vers le bas à cause de sa hauteur");
        envahisseur = new Envahisseur(position, dimension, vitesse);
    }

    private void positionValide(Dimension dimension, Position position, String messageHorsEspaceJeu, String messageDebordemmentLongueur, String messageDebordemmentLargeur) {
        int x = position.abscisse();
        int y = position.ordonnee();

        if (!estDansEspaceJeu(x, y))
            throw new HorsEspaceJeuException(messageHorsEspaceJeu);

        int longueurSprite = dimension.longueur();
        int hauteurSprite = dimension.hauteur();

        if (!estDansEspaceJeu(x + longueurSprite - 1, y))
            throw new DebordementEspaceJeuException(messageDebordemmentLongueur);
        if (!estDansEspaceJeu(x, y - hauteurSprite + 1))
            throw new DebordementEspaceJeuException(messageDebordemmentLargeur);
    }

    public Envahisseur recupererEnvahisseur() {
        return this.envahisseur;
    }
}
