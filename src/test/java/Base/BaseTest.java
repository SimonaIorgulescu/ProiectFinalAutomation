package Base;

import Pages.*;
import utils.ConfigReader;
import utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected MyAccountPage myAccountPage;
    protected NavigationPage navigationPage;
    protected HomePage homePage;
    protected ProductPage productPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected PaymentPage paymentPage;


    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        initializeDriver();
        initializePageObjects();
    }

        @AfterMethod(alwaysRun = true)
    public void tearDown(){
        DriverFactory.quitDriver();
    }

    private void initializeDriver(){
        driver = DriverFactory.getDriver();
        driver.get(ConfigReader.getProperty("baseUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void initializePageObjects(){
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);
        navigationPage = new NavigationPage(driver);
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        paymentPage = new PaymentPage(driver);
    }



//    @BeforeMethod
//    public void setUp(){
//        driver = DriverFactory.getDriver();
//        driver.get(ConfigReader.getProperty("baseUrl"));
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//    }






}
