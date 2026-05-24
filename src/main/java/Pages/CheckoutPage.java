package Pages;

import utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {

    private final WebDriver driver;


    By countryDropDown = By.xpath("//select[@id='country']");
    By postCodeField = By.id("postal_code");
    By houseNumberField = By.id("house_number");
    By streetNameField = By.id("street");
    By cityNameField = By.id("city");
    By stateNameField = By.id("state");


    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void checkoutForm(String country,String postCode,String houseNumber,String streetName,String cityName,String stateName){
        Select dropdown = new Select(driver.findElement(countryDropDown));
        dropdown.selectByVisibleText(country);
        WaitUtils.waitForClick(driver,driver.findElement(postCodeField)).sendKeys(postCode);
        WaitUtils.waitForClick(driver,driver.findElement(houseNumberField)).sendKeys(houseNumber);
        WaitUtils.waitForClick(driver,driver.findElement(streetNameField)).clear();
        driver.findElement(streetNameField).sendKeys(streetName);
        WaitUtils.waitForClick(driver,driver.findElement(cityNameField)).clear();
        driver.findElement(cityNameField).sendKeys(cityName);
        WaitUtils.waitForClick(driver,driver.findElement(stateNameField)).clear();
        driver.findElement(stateNameField).sendKeys(stateName);
    }

}
