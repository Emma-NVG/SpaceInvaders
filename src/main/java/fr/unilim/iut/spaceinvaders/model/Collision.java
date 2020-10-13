package fr.unilim.iut.spaceinvaders.model;

public class Collision {

    public boolean detecterCollision(Sprite spritecollisione, Sprite spritecollisioneur) {
        return this.detecterCollisionEntreSprite(spritecollisione, spritecollisioneur);
    }

    private boolean detecterCollisionEntreSprite(Sprite spritecollisione, Sprite spritecollisioneur) {
        return (this.collisionVertical(spritecollisione, spritecollisioneur) && this.collisionHorizontal(spritecollisione, spritecollisioneur));
    }

    private boolean collisionVertical(Sprite spritecollisione, Sprite spritecollisioneur) {
        return this.collisionParLeBas(spritecollisione, spritecollisioneur) ||
                this.collisionParLeHaut(spritecollisione, spritecollisioneur);
    }

    private boolean collisionHorizontal(Sprite spritecollisione, Sprite spritecollisioneur) {
        return this.collisionParLaGauche(spritecollisione, spritecollisioneur) ||
                this.collisionParLaDroite(spritecollisione, spritecollisioneur);
    }

    public boolean collisionParLaDroite(Sprite spritecollisione, Sprite spritecollisioneur) {
        return spritecollisione.abscisseLaPlusADroite() >= spritecollisioneur.abscisseLaPlusAGauche() &&
                spritecollisioneur.abscisseLaPlusADroite() >= spritecollisione.abscisseLaPlusAGauche();
    }

    public boolean collisionParLaGauche(Sprite spritecollisione, Sprite spritecollisioneur) {
        return spritecollisione.abscisseLaPlusAGauche() <= spritecollisioneur.abscisseLaPlusADroite() &&
                spritecollisioneur.abscisseLaPlusAGauche() <= spritecollisione.abscisseLaPlusADroite();
    }

    public boolean collisionParLeBas(Sprite spritecollisione, Sprite spritecollisioneur) {
        return spritecollisione.ordonneLaPlusHaute() >= spritecollisioneur.ordonneLaPlusBasse() &&
                spritecollisioneur.ordonneLaPlusHaute() >= spritecollisione.ordonneLaPlusBasse();
    }

    public boolean collisionParLeHaut(Sprite spritecollisione, Sprite spritecollisioneur) {
        return spritecollisione.ordonneLaPlusBasse() <= spritecollisioneur.ordonneLaPlusHaute() &&
                spritecollisioneur.ordonneLaPlusBasse() <= spritecollisione.ordonneLaPlusHaute();
    }
}
