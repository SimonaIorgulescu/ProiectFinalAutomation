package Pages;

import utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

   private final WebDriver driver;

   @FindBy(xpath = "//button[@id='btn-add-to-cart']")
    WebElement addToCartButton;

   @FindBy(xpath = "//button[@id='btn-add-to-favorites']")
   WebElement addToFavoritesButton;

   @FindBy(xpath = "//h1[@data-test='product-name']")
   WebElement productName;

   @FindBy(xpath = "//span[@data-test='unit-price']")
   WebElement productPrice;

   @FindBy(className = "toast-message")
   WebElement favoritesMessage;


    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void addToCart(){
        addToCartButton.click();
    }

    public void addToFavorites(){
        addToFavoritesButton.click();
    }

    public String getProductName(){
        return productName.getText();
    }

    public String getProductPrice(){
        return productPrice.getText();
    }

    public boolean addToFavoritesMessageAppeared(){
        WebElement message = WaitUtils.waitForVisibilityOfElement(driver,favoritesMessage);
        String textMessage = message.getText();
        if(textMessage.equals("Product added to your favorites list.")){
            System.out.println("Produsul a fost adaugat in lista de favorite.");
        }else{
            System.out.println("Produsul este deja adaugat in lista de favorite");
        }
        return message.isDisplayed();
    }


}
