package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    private final WebDriver driver;

    @FindBy(xpath = "//a[@data-test='nav-favorites']")
    WebElement favoritesButton;

    @FindBy(xpath = "//a[@data-test='nav-profile']")
    WebElement profileButton;

    @FindBy(xpath = "//a[@data-test='nav-invoices']")
    WebElement invoicesButton;

    @FindBy(xpath = "//a[@data-test='nav-messages']")
    WebElement messagesButton;

    public MyAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void goToFavorites(){
       favoritesButton.click();
    }

    public void goToProfile(){
        profileButton.click();
    }

    public void goToInvoices(){
        invoicesButton.click();
    }

    public void goToMessages(){
        messagesButton.click();
    }

//    public boolean isCorrectPage(String pageName){
//        return driver.findElement(By.xpath("//h1[text()='" + pageName + "']")).getText().contains(pageName);
//    }

}
