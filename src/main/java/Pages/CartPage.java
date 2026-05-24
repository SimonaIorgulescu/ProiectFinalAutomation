package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class CartPage {

    private final WebDriver driver;

    By itemsName = By.xpath("//span[@class='product-title']");

    @FindBy(xpath = "//button[@data-test='continue-shopping']")
    WebElement continueShoppingButton;


    @FindBy(xpath = "//p[@class='ng-star-inserted']")
    WebElement signedInCheckoutMessage;


    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void continueShopping() {
        continueShoppingButton.click();
    }


    public boolean isProductInCart(String productName) {
        List<WebElement> items = driver.findElements(itemsName);

        for (int i = 0; i < items.size(); i++) {
            String text = items.get(i).getText();

            if (text.equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }


    public boolean signedInCheckoutMessageDisplayed(String accountName) {
        String text = signedInCheckoutMessage.getText();
        String expectedMessage = "Hello " + accountName + ", you are already logged in. You can proceed to checkout.";
        return text.equals(expectedMessage);
    }
}