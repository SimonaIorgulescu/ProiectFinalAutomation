package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTests extends BaseTest {

    // 1 - Adăugare produs în coș

    @Test(priority = 1, groups = {"smoke","regression"})
    public void adaugaInCos(){

        homePage.clickOnProduct(" Combination Pliers ");
        productPage.addToCart();
        Assert.assertEquals(navigationPage.cartUpdated(),"1","Cosul de cumparaturi nu se actualizeaza dupa adaugarea unui produs in cos");
    }

    // 2 - Adăugare produs la favorite

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
