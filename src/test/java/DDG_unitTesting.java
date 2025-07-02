import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class DDG_unitTesting {

    WebDriver driver;

    @BeforeClass
    public void setup() {

//        ChromeOptions options = new ChromeOptions();
//
//        options.addArguments("user-data-dir=C:/Users/Hazem/AppData/Local/Google/Chrome/User Data");
//
//        options.addArguments("profile-directory=Default");
//
//        driver = new ChromeDriver(options);
//
//        driver.get("https://duckduckgo.com/");
//        driver.manage().window().maximize();

        driver = new ChromeDriver();
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


    //Search Box Checker
    @Test
    public void T3searchBox() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.className("searchbox_input__rnFzM"));
        searchBox.sendKeys("Selenium WebDriver");

        WebElement searchButton = driver.findElement(By.className("searchbox_searchButton__LxebD"));
        searchButton.click();

        Thread.sleep(2000);

        WebElement resultUrl = driver.findElement(By.xpath("//*[@id=\"r1-0\"]/div[3]/h2/a"));
        resultUrl.click();

        Thread.sleep(1000);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.selenium.dev/documentation/webdriver/";
        Assert.assertEquals(actualUrl, expectedUrl);
        System.out.println("Actual URL: " + actualUrl + "\nExpected URL: " + expectedUrl + "\nTest Passed!");
    }

    
    @AfterClass
    public void quit() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
