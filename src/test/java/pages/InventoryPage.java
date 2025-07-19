package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    WebDriver driver;

    By addToCartButton = By.xpath("//div[text() = 'Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//button[text() = 'ADD TO CART']");
    By cartButton = By.xpath("//a[@href='./cart.html']");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Add first product (Sauce Labs Backpack) to cart")
    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    @Step("Click on cart button to go to cart page")
    public void goToCart() {
        driver.findElement(cartButton).click();
    }


}
