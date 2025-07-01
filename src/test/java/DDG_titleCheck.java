import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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

    @Test
    public void titleCheck() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        Assert.assertNotEquals(actualTitle, expectedTitle);

        System.out.println("There is a bug as the actual is (" + actualTitle + ") and the expected is " + expectedTitle);

    }

    @AfterClass
    public void quit() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
