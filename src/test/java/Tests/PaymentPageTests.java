package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentPageTest extends BaseTest {

    @Test(groups = {"smoke","regression"})
    public void completePayment(){

        loginPage.logInAs("customer@practicesoftwaretesting.com","welcome01");
        Assert.assertTrue(loginPage.isUserLoggedIn(),"Userul nu este logat");
        navigationPage.goToHome();
        homePage.clickOnProduct(" Combination Pliers ");
        productPage.addToCart();
        navigationPage.goToCart();
        navigationPage.proceedToCheckout1();
        navigationPage.proceedToCheckout2();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        checkoutPage.checkoutForm("Algeria","5699784","52","Erdman Stream","Isobelshire","Vermont");
        navigationPage.proceedToCheckout3();
        paymentPage.selectPaymentMethod("Cash on Delivery");
        paymentPage.confirmPayment();
        Assert.assertTrue(paymentPage.isPaymentSuccessful());
    }
}
