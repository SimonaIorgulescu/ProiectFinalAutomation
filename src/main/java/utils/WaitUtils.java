package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtils {


    public static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClick(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClick(WebDriver driver, By locator){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }










}


//    public static WebElement waitForPresenceOfElement(WebDriver driver, WebElement element){
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        return wait.until(ExpectedConditions.presenceOfElementLocated(element));
//    }





//    public static void waitForTextToBePresent(By locator,String expectedText){
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));
//    }



//saucedemo
//    public static void waitForVisibility(WebDriver driver, By locator){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//    }
//
//    public static void waitForClick(WebDriver driver,By locator){
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(locator));
//}