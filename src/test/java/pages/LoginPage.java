package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By usernameField = By.id("user-name");

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    @Step("Login with username: {0} and password: {0}")
    public void login(String username, String password) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username, Keys.TAB, password, Keys.TAB, Keys.SPACE);
    }
}
