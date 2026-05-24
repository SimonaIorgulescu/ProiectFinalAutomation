package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTests extends BaseTest {

    // 1 - Verificare produs în coș

    @Test(groups = {"smoke","regression"})
    public void isProductInCart(){

        homePage.clickOnProduct(" Combination Pliers ");
        productPage.addToCart();
        navigationPage.goToCart();
        Assert.assertTrue(cartPage.isProductInCart("Combination Pliers "));
    }

    // 2 - Continue shopping din coș

    @Test(groups = {"smoke","regression"})
    public void continueShopping(){

        homePage.clickOnProduct(" Combination Pliers ");
        productPage.addToCart();
        navigationPage.goToCart();
        cartPage.continueShopping();
        Assert.assertTrue(navigationPage.isCorrectPage("https://practicesoftwaretesting.com/"));
    }

    // 3 - Continuare la Checkout fără autentificare

    @Test(groups = {"smoke","regression"})
    public void proceedToCheckoutWithoutBeingLoggedIn(){

        homePage.clickOnProduct(" Combination Pliers ");
        productPage.addToCart();
        navigationPage.goToCart();
        navigationPage.proceedToCheckout1();
        Assert.assertTrue(navigationPage.isCorrectPage("https://practicesoftwaretesting.com/checkout"));
    }

    // 4 - Continuare la Checkout cu utilizator autentificat

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