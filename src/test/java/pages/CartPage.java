package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    By checkoutButton = By.xpath("//a[text()='CHECKOUT']");
    By cartPageTitle = By.xpath("//div[text()='Your Cart']");

    public CartPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("driver waits for the cart page to load")
    public void waitForCartPageLoading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartPageTitle));
    }

    @Step("Click on the checkout button")
    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

}
