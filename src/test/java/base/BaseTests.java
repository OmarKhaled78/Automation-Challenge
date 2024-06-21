package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;

// BaseTests includes our setup and basic test logic while LoginTests includes the actual tests
public class BaseTests {
    private WebDriver driver;
    protected LoginPage loginPage;


@BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver" , "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage(driver); // the login page acts as our homepage because there is no homepage to the website




    }

    @AfterClass
    public void quitBrowser(){
    driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }

}
