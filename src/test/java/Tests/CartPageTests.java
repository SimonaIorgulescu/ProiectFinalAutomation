package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {

    @Test(groups = {"smoke","regression"})
    public void isProductInCart(){

        homePage.clickOnProduct(" Combination Pliers ");
        productPage.addToCart();
        navigationPage.goToCart();
        Assert.assertTrue(cartPage.isProductInCart("Combination Pliers "));
    }

    @Test(groups = {"smoke","regression"})
    public void continueShopping(){

        homePage.clickOnProduct(" Combination Pliers ");
        productPage.addToCart();
        navigationPage.goToCart();
        cartPage.continueShopping();
        Assert.assertTrue(navigationPage.isCorrectPage("https://practicesoftwaretesting.com/"));
    }

    @Test(groups = {"smoke","regression"})
    public void proceedToCheckoutWithoutBeingLoggedIn(){

        homePage.clickOnProduct(" Combination Pliers ");
        productPage.addToCart();
        navigationPage.goToCart();
        navigationPage.proceedToCheckout1();
        Assert.assertTrue(navigationPage.isCorrectPage("https://practicesoftwaretesting.com/checkout"));
    }

    @Test(groups = {"smoke","regression"})
    public void proceedToCheckoutBeingLoggedIn(){

        loginPage.logInAs("customer@practicesoftwaretesting.com","welcome01");
        Assert.assertTrue(loginPage.isUserLoggedIn(),"Userul nu este logat");
        navigationPage.goToHome();
        homePage.clickOnProduct(" Combination Pliers ");
        productPage.addToCart();
        navigationPage.goToCart();
        navigationPage.proceedToCheckout1();
        Assert.assertTrue(cartPage.signedInCheckoutMessageDisplayed("Jane Doe"),"Mesajul nu este afisat");
        navigationPage.proceedToCheckout2();
    }
}