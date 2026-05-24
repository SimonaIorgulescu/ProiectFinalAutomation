package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {

    // 1. Login cu credentiale valide

    @Test(priority = 0, groups = {"smoke", "regression"})
    public void loginValid(){

        loginPage.logInAs("customer@practicesoftwaretesting.com","welcome01");
        Assert.assertTrue(loginPage.isUserLoggedIn(),"Userul nu este logat");
    }

    // 2. Login cu email gresit si parola corecta

    @Test(priority = 1, groups = {"regression"})
    public void loginInvalid(){

        loginPage.logInAs("simona.iorgulescu@yahoo.com","welcome01");
        Assert.assertTrue(loginPage.invalidLoginMessage(),"Mesajul de eroare nu este afisat corect");
    }

    // 3. Login cu camp Password gol si email corect

    @Test(priority = 2, groups = {"regression"})
    public void loginCuCampPasswordGol(){

        loginPage.logInAs("customer@practicesoftwaretesting.com","");
        Assert.assertTrue(loginPage.emptyPasswordMessage(),"Mesajul de eroare pentru parola nu este afisat corect");
    }

    // 4. Login cu camp email gol si parola corecta

    @Test(priority = 3, groups = {"regression"})
    public void loginCuCampEmailGol(){

        loginPage.logInAs("","welcome01");
        Assert.assertTrue(loginPage.emptyEmailMessage(),"Mesajul de eroare pentru email nu este afisat corect");
    }

    // 5. Login cu campurile pentru credentiale goale

    @Test(priority = 4, groups = {"regression"})
    public void loginCuCredentialeGoale(){

        loginPage.logInAs("","");
        Assert.assertTrue(loginPage.emptyEmailMessage(),"Mesajul de eroare pentru email nu este afisat corect");
        Assert.assertTrue(loginPage.emptyPasswordMessage(),"Mesajul de eroare pentru parola nu este afisat corect");
    }

    // 6. Deconectare din cont

    @Test(priority = 5, groups = {"smoke", "regression"})
    public void signOut(){
        loginPage.logInAs("customer@practicesoftwaretesting.com","welcome01");
        Assert.assertTrue(loginPage.isUserLoggedIn(),"Userul nu este logat");
        navigationPage.signOut();
    }

}
