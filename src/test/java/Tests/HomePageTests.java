package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {


    @Test(groups = {"regression"})
    public void sorteazaProdusele(){

        homePage.sortByOption("Price (High - Low)");
        Assert.assertEquals(homePage.areProductsSorted(),"Price (High - Low)","Produsele nu sunt filtrate corect");

    }

    @Test(groups = {"regression"})
    public void cautaProdus(){

        homePage.searchProduct("hammer");
        Assert.assertTrue(homePage.productsMatchTheSearch("hammer"));
    }

    @Test(groups = {"regression"})
    public void filtreazaProdusele(){

        homePage.filterBy(" Hammer ");
        Assert.assertTrue(homePage.isFilterSelected(" Hammer "));
    }

}
