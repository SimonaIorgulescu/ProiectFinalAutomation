package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountPageTests extends BaseTest {

    // 1 - Accesare pagină Favorites

    @Test(groups = {"regression"})
    public void navigheazaLaFavorites(){

        loginPage.logInAs("customer@practicesoftwaretesting.com","welcome01");
        myAccountPage.goToFavorites();
        Assert.assertTrue(navigationPage.isCorrectPage("https://practicesoftwaretesting.com/account/favorites"));

    }

    // 2 - Accesare pagină Profile

    @Test(groups = {"regression"})
    public void navigheazaLaProfile(){

        loginPage.logInAs("customer@practicesoftwaretesting.com","welcome01");
        myAccountPage.goToProfile();
        Assert.assertTrue(navigationPage.isCorrectPage("https://practicesoftwaretesting.com/account/profile"));
    }

    // 3 - Accesare pagină Invoices

    @Test(groups = {"regression"})
    public void navigheazaLaInvoices(){

        loginPage.logInAs("customer@practicesoftwaretesting.com","welcome01");
        myAccountPage.goToInvoices();
        Assert.assertTrue(navigationPage.isCorrectPage("https://practicesoftwaretesting.com/account/invoices"));
    }

    // 4 - Accesare pagină Messages

    @Test(groups = {"regression"})
    public void navigheazaLaMessages(){

        loginPage.logInAs("customer@practicesoftwaretesting.com","welcome01");
        myAccountPage.goToMessages();
        Assert.assertTrue(navigationPage.isCorrectPage("https://practicesoftwaretesting.com/account/messages"));
    }

    // 5 - Navigare folosind dropdown-ul My Account

    @Test(groups = {"regression"})
    public void accountNavigateDropdown(){
        loginPage.logInAs("customer@practicesoftwaretesting.com","welcome01");
        navigationPage.myAccountDropdown("My favorites");
    }

}
