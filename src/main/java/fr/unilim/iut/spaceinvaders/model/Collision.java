package fr.unilim.iut.spaceinvaders.model;

import java.awt.*;

public class Collision {

    public static boolean detecterCollision(Sprite sprite1, Sprite sprite2) {
        Rectangle r1 = new Rectangle(sprite1.origine.x, sprite1.origine.y, sprite1.dimension.longueur, sprite1.dimension.hauteur);
        Rectangle r2 = new Rectangle(sprite2.origine.x, sprite2.origine.y, sprite2.dimension.longueur, sprite2.dimension.hauteur);

        if(r1.intersects(r2)){
            return true;
        }else{
            return false;
        }
    }

}
