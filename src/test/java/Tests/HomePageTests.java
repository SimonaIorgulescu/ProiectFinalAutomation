package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    // 1 - Sortare produse după preț descrescător

    @Test(groups = {"regression"})
    public void sorteazaProdusele(){

        homePage.sortByOption("Price (High - Low)");
        Assert.assertEquals(homePage.areProductsSorted(),"Price (High - Low)","Produsele nu sunt filtrate corect");

    }

    // 2 - Căutare produs după keyword

    @Test(groups = {"regression"})
    public void cautaProdus(){

        homePage.searchProduct("hammer");
        Assert.assertTrue(homePage.productsMatchTheSearch("hammer"));
    }

    // 3 - Filtrare produse după categorie

    @Test(groups = {"regression"})
    public void filtreazaProdusele(){

        homePage.filterBy(" Hammer ");
        Assert.assertTrue(homePage.isFilterSelected(" Hammer "));
    }

}
