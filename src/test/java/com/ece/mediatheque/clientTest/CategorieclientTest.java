package com.ece.mediatheque.clientTest;

import com.ece.mediatheque.mediatheque.client.CategorieClient;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Edgar on 25/10/2016.
 */
public class CategorieclientTest {

    @Test
    public void test_create_categoreClient_with_nom_max_cot_coaefDuree_coefTarif_codeReducActif() {
        CategorieClient categorieClient = new CategorieClient("denis", 1000, 10.2, 1.1, 1.2, true);
        Assert.assertEquals("denis", categorieClient.getNom());
        Assert.assertEquals(1000, categorieClient.getNbEmpruntMax());
        Assert.assertEquals(10.2, categorieClient.getCotisation(), 0);
        Assert.assertEquals(1.1, categorieClient.getCoefDuree(), 0);
        Assert.assertEquals(1.2, categorieClient.getCoefTarif(), 0);
        Assert.assertTrue(categorieClient.getCodeReducUtilise());
    }

    @Test
    public void test_categorieClient_modifierCotisation_OK() {

        String name = "Premium";
        int max = 2;
        double cot = 5;
        double coefDuree = 1.5;
        double coefTarif = 1.5;
        boolean codeReducUsed = false;

        double nCot = 6;

        // Creation object CategorieClient
        CategorieClient c = new CategorieClient(name, max, cot, coefDuree, coefTarif, codeReducUsed);
        // Modification de la cotisation
        c.modifierCotisation(nCot);
        //Verification de la modification
        Assert.assertTrue(c.getCotisation() == nCot);

    }

    @Test
    public void test_create_categoreClient_with_nom() {
        CategorieClient categorieClient = new CategorieClient("denis");
        Assert.assertEquals("denis", categorieClient.getNom());
        Assert.assertEquals(0, categorieClient.getNbEmpruntMax());
        Assert.assertEquals(0, categorieClient.getCotisation(), 0);
        Assert.assertEquals(0, categorieClient.getCoefDuree(), 0);
        Assert.assertEquals(0, categorieClient.getCoefTarif(), 0);
        Assert.assertFalse(categorieClient.getCodeReducUtilise());
    }

    @Test
    public void test_equals_Symmetric() {
        CategorieClient x = new CategorieClient("Denis");  // equals and hashCode check name field value
        CategorieClient y = new CategorieClient("Denis");
        Assert.assertTrue(x.equals(y) && y.equals(x));
        Assert.assertTrue(x.hashCode() == y.hashCode());
    }

    @Test
    public void test_notEquals() {
        CategorieClient x = new CategorieClient("Denis");
        CategorieClient y = new CategorieClient("Denis 2");
        Assert.assertFalse(x.equals(y) && y.equals(x));
        Assert.assertFalse(x.equals(null));
        Assert.assertFalse(x.equals("Denis"));
    }

}
