package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    By firstName = By.id("first-name");
    By checkOutPageTitle = By.xpath("//div[text()='Checkout: Your Information']");

    public CheckoutPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step ("driver waits for the checkout page to load")
    public void waitForCheckoutPageLoading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkOutPageTitle));
    }

    @Step ("Enter checkout data: First Name = {H}, Last Name = {O}, Zip Code = {222}")
    public void enterCheckoutData (String f, String l, String z) {
        driver.findElement(firstName).sendKeys(f, Keys.TAB, l, Keys.TAB, z, Keys.ENTER);
    }
}
