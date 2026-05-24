package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountPageTest extends BaseTest {

    @Test(groups = {"regression"})
    public void navigheazaLaFavorites(){

        loginPage.logInAs("customer@practicesoftwaretesting.com","welcome01");
        myAccountPage.goToFavorites();
        Assert.assertTrue(navigationPage.isCorrectPage("https://practicesoftwaretesting.com/account/favorites"));

    }

    @Test(groups = {"regression"})
    public void navigheazaLaProfile(){

        loginPage.logInAs("customer@practicesoftwaretesting.com","welcome01");
        myAccountPage.goToProfile();
        Assert.assertTrue(navigationPage.isCorrectPage("https://practicesoftwaretesting.com/account/profile"));
    }

    @Test(groups = {"regression"})
    public void navigheazaLaInvoices(){

        loginPage.logInAs("customer@practicesoftwaretesting.com","welcome01");
        myAccountPage.goToInvoices();
        Assert.assertTrue(navigationPage.isCorrectPage("https://practicesoftwaretesting.com/account/invoices"));
    }

    @Test(groups = {"regression"})
    public void navigheazaLaMessages(){

        loginPage.logInAs("customer@practicesoftwaretesting.com","welcome01");
        myAccountPage.goToMessages();
        Assert.assertTrue(navigationPage.isCorrectPage("https://practicesoftwaretesting.com/account/messages"));
    }

    @Test(groups = {"regression"})
    public void accountNavigateDropdown(){
        loginPage.logInAs("customer@practicesoftwaretesting.com","welcome01");
        navigationPage.myAccountDropdown("My favorites");
    }

}
