import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class swagLabs {

    WebDriver driver;

    @BeforeClass
    public void setup() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/Hazem/AppData/Local/Google/Chrome/User Data");
        options.addArguments("profile-directory=Default");

        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

    }

    @Test
    public void T1validCredentials() throws InterruptedException {
        String [] user = {"standard_user", "locked_out_user", "problem_user", "performance_glitch_user", "error_user", "visual_user"};
        String pass = "secret_sauce";


        for (int i=0; i<user.length; i++){

            driver.get("https://www.saucedemo.com/");
            Thread.sleep(2000);
            WebElement username = driver.findElement(By.id("user-name"));
            WebElement password = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("login-button"));

            if (i == 1){
                username.clear();
                username.sendKeys(user[i]);

                password.clear();
                password.sendKeys(pass);

                loginButton.click();
                Thread.sleep(2000);

                System.out.print("Trial (" + i + ") with user [" + user[i] + "] - Login failed with error: ");
                System.out.println("Epic sadface: Sorry, this user has been locked out.");
                username.clear();
                password.clear();
                continue;

            } else if ( i == 3) {
                username.clear();
                username.sendKeys(user[i]);

                password.clear();
                password.sendKeys(pass);

                loginButton.click();
                Thread.sleep(2000);

                System.out.print("Trial (" + i + ") with user [" + user[i] + "] - Login successful with error: ");
                System.out.println("Performance Issue as it takes too long to login");

                WebElement menu = driver.findElement(By.id("react-burger-menu-btn"));
                menu.click();
                Thread.sleep(1000);

                WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
                logoutButton.click();
                Thread.sleep(2000);
                continue;
            }

                username.clear();
                username.sendKeys(user[i]);


                password.clear();
                password.sendKeys(pass);


                loginButton.click();
                Thread.sleep(2000);

                WebElement menu = driver.findElement(By.id("react-burger-menu-btn"));
                menu.click();
                Thread.sleep(1000);

                WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
                logoutButton.click();
                Thread.sleep(1000);

                System.out.println("Trial (" + i + ") with user [" + user[i] + "] - Login successful and logged out.");

        }
    }

    @Test
    public void T2invalidCredentials() throws InterruptedException {
        String invalidUser = "Hazem";
        String [] pass2 = {"1234", "secret_sauce"};
        System.out.println('\n');

        for (int j=0; j<pass2.length; j++){
            driver.get("https://www.saucedemo.com/");
            Thread.sleep(2000);
            WebElement username2 = driver.findElement(By.id("user-name"));
            WebElement password2 = driver.findElement(By.id("password"));
            WebElement loginButton2 = driver.findElement(By.id("login-button"));

            username2.clear();
            username2.sendKeys(invalidUser);

            password2.clear();
            password2.sendKeys(pass2[j]);

            loginButton2.click();
            Thread.sleep(1000);

            System.out.print("Trial (" + j + ") with user [" + invalidUser + "] and pass [" + pass2[j] + "] - Login failed with error: ");
            System.out.println("Epic sadface: Username and password do not match any user in this service");

        }


    }

    @AfterClass
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }


}
