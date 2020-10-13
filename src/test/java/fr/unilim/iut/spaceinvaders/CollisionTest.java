package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CollisionTest {
    private SpaceInvaders spaceinvaders;
    private Collision collision;

    @Before
    public void initialisation() {
        collision = new Collision();
        spaceinvaders = new SpaceInvaders(15, 15);
    }

    @Test
    public void test_PasDeCollisionDetecte() {
        spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(2, 2), new Position(7, 9), 1);
        spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(2, 2), new Position(7, 1), 1);
        assertEquals(false, collision.detecterCollision(spaceinvaders.recupererVaisseau(), spaceinvaders.recupererEnvahisseur()));
    }

    @Test
    public void test_DetectionCollision() {
        spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(5, 4), new Position(6, 3), 1);
        spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(5, 2), new Position(7, 2), 1);
        assertEquals(true, collision.detecterCollision(spaceinvaders.recupererVaisseau(), spaceinvaders.recupererEnvahisseur()));
    }

    @Test
    public void test_DetectionCollision_ParLaDroite() {
        spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3, 2), new Position(6, 2), 1);
        spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(3, 2), new Position(7, 1), 1);
        assertEquals(true, collision.collisionParLaDroite(spaceinvaders.recupererVaisseau(), spaceinvaders.recupererEnvahisseur()));
    }

    @Test
    public void test_DetectionCollision_ParLaGauche() {
        spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(3, 2), new Position(8, 1), 1);
        spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(3, 2), new Position(7, 1), 1);
        assertEquals(true, collision.collisionParLaGauche(spaceinvaders.recupererVaisseau(), spaceinvaders.recupererEnvahisseur()));
    }

    @Test
    public void test_DetectionCollision_ParLeHaut() {
        spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(4, 3), new Position(8, 4), 1);
        spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(4, 3), new Position(7, 3), 1);
        assertEquals(true, collision.collisionParLeHaut(spaceinvaders.recupererVaisseau(), spaceinvaders.recupererEnvahisseur()));
    }

    @Test
    public void test_DetectionCollision_ParLeBas() {
        spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(4, 3), new Position(8, 2), 1);
        spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(4, 3), new Position(7, 3), 1);
        assertEquals(true, collision.collisionParLeBas(spaceinvaders.recupererVaisseau(), spaceinvaders.recupererEnvahisseur()));
    }

    @Test
    public void test_DetectionCollision_EnvahisseurMissile() {
        spaceinvaders.positionnerUnNouveauVaisseau(new Dimension(10, 3), new Position(0, 9), 1);
        spaceinvaders.positionnerUnNouvelEnvahisseur(new Dimension(10, 2), new Position(0, 5), 1);
        spaceinvaders.tirerUnMissile(new Dimension(3, 2), 2);
        spaceinvaders.deplacerMissile();
        spaceinvaders.detecterCollision_EnvahisseurMissile();
        assertEquals(true, spaceinvaders.partieFinie());
    }

}
