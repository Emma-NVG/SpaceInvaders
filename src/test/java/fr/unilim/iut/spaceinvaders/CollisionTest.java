package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CollisionTest {
    private SpaceInvaders spaceinvaders;

    @Before
    public void initialisation() {
        spaceinvaders = new SpaceInvaders(15, 10);
    }

    @Test
    public void test_PasDeCollision() {
        spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(2, 2), new Position(7, 9), 1);
        spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(2, 2), new Position(7, 1), 1);
        assertEquals(false, Collision.detecterCollision(spaceinvaders.recupererVaisseau(),spaceinvaders.recupererEnvahisseur()));
    }

    @Test
    public void test_CollisionComplete() {
        spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(5, 4), new Position(6, 3), 1);
        spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(5, 2), new Position(7, 2), 1);
        assertEquals(true, Collision.detecterCollision(spaceinvaders.recupererVaisseau(),spaceinvaders.recupererEnvahisseur()));
    }

    @Test
    public void test_CollisionPartielleADroite() {
        spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3, 2), new Position(6, 2), 1);
        spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(3, 2), new Position(7, 1), 1);
        assertEquals(true, Collision.detecterCollision(spaceinvaders.recupererVaisseau(),spaceinvaders.recupererEnvahisseur()));
    }

    @Test
    public void test_CollisionPartielleAGauche() {
        spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3, 2), new Position(8, 1), 1);
        spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(3, 2), new Position(7, 1), 1);
        assertEquals(true, Collision.detecterCollision(spaceinvaders.recupererVaisseau(),spaceinvaders.recupererEnvahisseur()));
    }

    @Test
    public void test_CollisionPartielleEnHaut() {
        spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(4, 3), new Position(8, 4), 1);
        spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(4, 3), new Position(7, 3), 1);
        assertEquals(true, Collision.detecterCollision(spaceinvaders.recupererVaisseau(),spaceinvaders.recupererEnvahisseur()));
    }

    @Test
    public void test_CollisionPartielleEnBas() {
        spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(4, 3), new Position(8, 2), 1);
        spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(4, 3), new Position(7, 3), 1);
        assertEquals(true, Collision.detecterCollision(spaceinvaders.recupererVaisseau(),spaceinvaders.recupererEnvahisseur()));
    }

}
