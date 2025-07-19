package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class E2ETest extends BaseTest {

    @Test(description = "User can log in, add product to cart, checkout and complete order")
    @Story("User completes a full successful purchase flow")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test full user flow: login -> add to cart -> checkout -> order overview -> finish order")

    public void flowPurchaseTest() {
        LoginPage loginPage1 = new LoginPage(driver);
        InventoryPage inventoryPage1 = new InventoryPage(driver);
        CartPage cartPage1 = new CartPage(driver);
        CheckoutPage checkoutPage1 = new CheckoutPage(driver);
        CheckoutOverviewPage checkoutOverviewPage1 = new CheckoutOverviewPage(driver);

        loginPage1.login("standard_user", "secret_sauce");

        inventoryPage1.addToCart();
        inventoryPage1.goToCart();

        cartPage1.waitForCartPageLoading();
        cartPage1.clickCheckoutButton();

        checkoutPage1.waitForCheckoutPageLoading();
        checkoutPage1.enterCheckoutData("Hazem", "Osama", "22222");

        checkoutOverviewPage1.finishOrder();

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete"));
    }
}
