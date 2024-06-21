package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// This class represents the page that we are redirected to after a successful login
public class LoginRedirectPage {

    private WebDriver driver;
    private By appLogoDiv = By.className("app_logo");

    public LoginRedirectPage(WebDriver driver){
        this.driver = driver;

    }
    public WebElement getAppLogoDiv(){
        WebElement LogoDiv = driver.findElement(appLogoDiv);

        return LogoDiv;
    }
}
