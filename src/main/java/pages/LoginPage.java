package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Using Page Object Model pattern to separate UI elements from tests
// This class represents the login page being tested
public class LoginPage {
    private WebDriver driver; //Field for our webdriver
    private By userNameField = By.id("user-name"); // Locator for the Username field
    private By passwordField = By.id("password"); // Locator for the Password field
    private By loginButton = By.id("login-button"); // Locator for the Login button
    private By errorMessageDiv = By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]"); // Locator for our error message div in case of invalid login credentials


    public LoginPage(WebDriver driver){ // Constructor
        this.driver = driver;

    }
    public WebElement getUserNameField(){ // Method to get the username field on the page
        WebElement userName = driver.findElement(userNameField);
        return userName;
    }
    public WebElement getPasswordField(){ // Method to get the password field on the page
        WebElement Password = driver.findElement(passwordField);
        return Password;

    }

    public void enterUsername(String userName){ // Method to enter a username into the Username field
        driver.findElement(userNameField).sendKeys(userName);

    }

    public void enterPassword(String password){ // Method to enter a password into the password field
        driver.findElement(passwordField).sendKeys(password);

    }
    public WebElement getErrorMessageDiv(){ // Method to get the div that contains the error message for incorrect login attempts
        return driver.findElement(errorMessageDiv);


    }

    public  LoginRedirectPage clickLogin(){ // Method to click the login button and return an instance of the redirected page object

        driver.findElement(loginButton).click();
        return new LoginRedirectPage(driver);
    }

}
