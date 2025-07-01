import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DDG_titleCheck {

    WebDriver driver;

    @BeforeClass
    public void setup() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("user-data-dir=C:/Users/Hazem/AppData/Local/Google/Chrome/User Data");

        options.addArguments("profile-directory=Default");

        driver = new ChromeDriver(options);

        driver.get("https://duckduckgo.com/");
        driver.manage().window().maximize();
    }


    //Title Checking
    @Test
    public void T1titleCheck(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("There is a bug as the actual is (" + actualTitle + ") and the expected is " + expectedTitle);
    }


    //Logo Checker
    @Test
    public void T2logoExist(){
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/main/article/div[1]/div[1]/div[2]/div/header/div/section[1]/a/img"));

        Assert.assertTrue(logo.isDisplayed(), "DuckDuckGo Logo is not displayed");
    }

    
    @AfterClass
    public void quit() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
