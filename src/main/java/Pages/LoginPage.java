package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final WebDriver driver;

    @FindBy(xpath = "//a[@data-test='nav-sign-in']")
    WebElement signInButton;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@data-test='login-submit']")
    WebElement logInButton;

    @FindBy(xpath = "//button[@data-test='nav-menu']")
    WebElement userMenu;

    @FindBy(xpath = "//div[@data-test='login-error']/child::div")
    WebElement errorMessage;

    @FindBy(id = "email-error")
    WebElement emailError;

    @FindBy(id = "password-error")
    WebElement passwordError;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public MyAccountPage logInAs(String email, String password) {
        signInButton.click();
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        logInButton.click();
        return new MyAccountPage(driver);
    }


    public boolean isUserLoggedIn() {
        return userMenu.isDisplayed();
    }


    public boolean invalidLoginMessage() {
        String expectedMessage = "Invalid email or password";
        return errorMessage.getText().trim().equals(expectedMessage);
    }


    public boolean emptyEmailMessage() {
        return emailError.getText().equals("Email is required");
    }


    public boolean emptyPasswordMessage() {
        return passwordError.getText().equals("Password is required");
    }

}



