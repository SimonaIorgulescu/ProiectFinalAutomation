package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage {

    private final WebDriver driver;

    @FindBy(id = "payment-method")
    WebElement paymentDropdown;

    @FindBy(xpath = "//button[@data-test='finish']")
            WebElement confirmButton;

    @FindBy(xpath = "//div[@data-test='payment-success-message']")
            WebElement successfulMessage;


    public PaymentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void selectPaymentMethod(String option){
        Select dropdown = new Select(paymentDropdown);
        dropdown.selectByVisibleText(option);
    }

    public void confirmPayment(){
        confirmButton.click();
    }

    public boolean isPaymentSuccessful(){
        String actualMessage = successfulMessage.getText();
        String expectedMessage = "Payment was successful";
        return actualMessage.equals(expectedMessage);
    }

}
