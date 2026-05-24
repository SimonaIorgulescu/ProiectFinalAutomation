package Pages;

import utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPage {

    private final WebDriver driver;

    @FindBy(xpath = "//a[@data-test='nav-home']")
    WebElement homeButton;

    @FindBy(xpath = "//button[@data-test='nav-categories']")
    WebElement categoriesDropDown;

    @FindBy(xpath = "//a[@data-test='nav-contact']")
    WebElement contactButton;

    @FindBy(xpath = "//a[@data-test='nav-sign-in']")
    WebElement signInButton;

    @FindBy(xpath = "//button[@data-test='language-select']")
    WebElement languageSelectDropdown;

    @FindBy(xpath = "//button[@data-test='language-select']")
    WebElement language;

    @FindBy(xpath = "//a[@data-test='nav-cart']")
    WebElement cartButton;

    @FindBy(xpath = "//span[@data-test='cart-quantity']")
    WebElement cartIcon;

    @FindBy(xpath = "//button[@data-test='proceed-1']")
    WebElement proceedToCheckoutButton1;

    @FindBy(xpath = "//button[@data-test='proceed-2']")
    WebElement proceedToCheckoutButton2;

    @FindBy(xpath = "//button[@data-test='proceed-3']")
    WebElement proceedToCheckoutButton3;

    @FindBy(xpath ="//a[@data-test='nav-sign-out']")
    WebElement signOutButton;

    @FindBy(xpath = "//button[@data-test='nav-menu']")
    WebElement userMenu;


    public NavigationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void goToHome(){
        WaitUtils.waitForVisibilityOfElement(driver,homeButton).click();
    }

    public void goToCategory(String optionName){
        categoriesDropDown.click();
        driver.findElement(By.xpath("//a[text()='" + optionName + "']")).click();
    }

    public void goToContact(){
        contactButton.click();
    }


    public void changeLanguage(String optionText){
        languageSelectDropdown.click();
        driver.findElement(By.xpath("//a[text()='" + optionText + "']")).click();
    }

    public boolean isLanguageSelected(String selection){
        String selectedLanguage = language.getText();
        return selectedLanguage.contains(selection);
    }


    public void signOut(){
        userMenu.click();
        signOutButton.click();
    }


    public void goToCart(){
        cartButton.click();
    }

    public void myAccountDropdown(String navigateTo){
        String xpath = "//a[text()='" + navigateTo + "']";
        userMenu.click();
        driver.findElement(By.xpath(xpath)).click();
    }

    public String cartUpdated(){
        return cartIcon.getText();
    }

    public boolean isCorrectPage(String expectedURL){
        String currentURL = driver.getCurrentUrl();
        return currentURL.equals(expectedURL);
    }

    public void proceedToCheckout1(){
        proceedToCheckoutButton1.click();
    }

    public void proceedToCheckout2(){
        proceedToCheckoutButton2.click();
    }

    public void proceedToCheckout3(){
        WaitUtils.waitForClick(driver,proceedToCheckoutButton3).click();
        }

    }


