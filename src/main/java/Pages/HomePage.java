package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {

    private final WebDriver driver;

    By searchBar = By.xpath("//input[@id='search-query']");
    By submitButton = By.xpath("//button[@data-test='search-submit']");
    By sortDropdown = By.xpath("//select[@data-test='sort']");
    By searchCompleted = By.xpath("//div[@data-test='search_completed']//h5[@data-test='product-name']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void sortByOption(String sortBy) {
        Select dropdown = new Select(driver.findElement(sortDropdown));
        dropdown.selectByVisibleText(sortBy);
    }

    public String areProductsSorted() {
        Select dropdown = new Select(driver.findElement(sortDropdown));
        return dropdown.getFirstSelectedOption().getText();
    }


    public void searchProduct(String product) {
        driver.findElement(searchBar).sendKeys(product);
        driver.findElement(submitButton).click();
    }

    public boolean productsMatchTheSearch(String product) {
        List<WebElement> elements = driver.findElements(searchCompleted);
        for (WebElement element : elements) {
            String products = element.getText().trim();
            if (!products.toLowerCase().contains(product.toLowerCase())) {
                return false;
            }
        }
        return true;
    }



    public void filterBy(String option) {
        By checkboxLocator = By.xpath("//label[contains(text(),'" + option + "')]/child::input");
        WebElement checkbox = driver.findElement(checkboxLocator);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }


    public boolean isFilterSelected(String filterName) {
        WebElement checkbox = driver.findElement(By.xpath("//label[contains(text(),'" + filterName + "')]/child::input"));
        return checkbox.isSelected();
    }

    public void clickOnProduct(String productName) {
        String xpath = "//h5[text()='" + productName + "']";
        driver.findElement(By.xpath(xpath)).click();
    }

}




