import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Google {
    WebDriver driver;

    @BeforeClass
    public void setup() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("user-data-dir=C:/Users/Hazem/AppData/Local/Google/Chrome/User Data");

        options.addArguments("profile-directory=Default");

        driver = new ChromeDriver(options);

        driver.get("https://www.google.com/?gfe_rd=cr&ei=vLRqV9jyO86s8we_kYHwDA");
        driver.manage().window().maximize();
    }

    @Test
    public void T2logoExist(){

        WebElement logo = driver.findElement(By.className("lnXdpd"));
        if (logo.isDisplayed()){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
        //Assert.assertTrue(logo.isDisplayed(), "DuckDuckGo Logo is displayed");
    }

    @AfterClass
    public void quit() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
