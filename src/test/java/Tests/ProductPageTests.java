package Tests;

import Base.BaseTest;
import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {


    @Test(priority = 1, groups = {"smoke","regression"})
    public void adaugaInCos(){

        homePage.clickOnProduct(" Combination Pliers ");
        productPage.addToCart();
        Assert.assertEquals(navigationPage.cartUpdated(),"1","Cosul de cumparaturi nu se actualizeaza dupa adaugarea unui produs in cos");
    }

    @Test(priority = 2, groups = {"regression"})
    public void adaugaLaFavorites(){

        loginPage.logInAs("customer@practicesoftwaretesting.com","welcome01");
        Assert.assertTrue(loginPage.isUserLoggedIn(),"Userul nu este logat");
        navigationPage.goToHome();
        homePage.clickOnProduct(" Combination Pliers ");
        productPage.addToFavorites();
        Assert.assertTrue(productPage.addToFavoritesMessageAppeared());
    }

}
