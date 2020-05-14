package fr.unilim.iut.spaceinvaders;

import fr.unilim.iut.spaceinvaders.model.Dimension;
import fr.unilim.iut.spaceinvaders.model.Position;
import fr.unilim.iut.spaceinvaders.model.SpaceInvaders;
import fr.unilim.iut.spaceinvaders.model.Vaisseau;
import fr.unilim.iut.spaceinvaders.utils.MissileException;
import org.junit.Before;
import org.junit.Test;

public class VaisseauTest {
    private SpaceInvaders spaceinvaders;

    @Before
    public void initialisation() {
        spaceinvaders = new SpaceInvaders(15, 10);
    }

    @Test(expected = MissileException.class)
    public void test_LongueurMissileSuperieureALongueurVaisseau_UneExceptionEstLevee() throws Exception {
        Vaisseau vaisseau = new Vaisseau(new Dimension(5, 2), new Position(5, 9), 1);
        vaisseau.tirerUnMissile(new Dimension(7, 2), 1);
    }

}
