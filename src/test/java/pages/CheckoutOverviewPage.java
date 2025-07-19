package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {

    WebDriver driver;

    By finishButton = By.xpath("//a[text()='FINISH']");

    public CheckoutOverviewPage (WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on Finish button to complete the order")
    public void finishOrder() {
        driver.findElement(finishButton).click();
    }

}
