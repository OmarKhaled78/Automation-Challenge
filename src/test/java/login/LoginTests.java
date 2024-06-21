package login;

import base.BaseTests;
import static org.testng.Assert.*;

import org.testng.annotations.Test;
import pages.LoginRedirectPage;

import java.time.Duration;

public class LoginTests extends BaseTests  { // BaseTests class includes all the setup and basic test logic while LoginTests contains the actual tests

/* Test to verify that the Username
   and Password fields exist on the page and are also visible
 */
    @Test
    public void checkForUsernameAndPasswordFields(){
    var userNameField = loginPage.getUserNameField();
    var passwordField = loginPage.getPasswordField();
    assertNotNull(userNameField , "Username Field does not exist on the page");
    assertNotNull(passwordField , "Password Field does not exist on the page");
    //After making sure that the fields exist on the page
    //Asserting that they are also visible, display an error message in console if not
    assertTrue(userNameField.isDisplayed() , "Username field is not visible");
    assertTrue(passwordField.isDisplayed() , "Password field is not visible");



    }

    /*Testing login with valid credentials and verifying that
    the Swag Labs div is visible and contains the text "Swag Labs"
     */
    @Test
    public void testValidLogin(){
         loginPage.enterUsername("standard_user");
         loginPage.enterPassword("secret_sauce");
        LoginRedirectPage loginRedirectPage = loginPage.clickLogin();
        var LogoDiv = loginRedirectPage.getAppLogoDiv();
        assertTrue(LogoDiv.isDisplayed());
        assertEquals(LogoDiv.getText() , "Swag Labs" , "Text in div mismatch");


    }
/*Testing login with invalid credentials and verifying that
the div for the error message is visible and the text
in the div matches the text that would be displayed
when attempting to log in with invalid credentials
 */
    @Test
    public void testInvalidLogin(){
        loginPage.enterUsername("iam_an_invalid_username");
        loginPage.enterPassword("iam_an_invalid_password");
        loginPage.clickLogin();
        var errorMessageDiv = loginPage.getErrorMessageDiv();
        assertTrue(errorMessageDiv.isDisplayed());
        assertEquals(errorMessageDiv.getText() ,
                "Epic sadface: Username and password do not match any user in this service" ,
                "Error message text in div mismatch");

    }
/* Testing login while entering password and leaving
   Username empty and verifying that the div for the error
   message is visible and contains text that matches the
   text that would be displayed when attempting to log in
   with no username
 */
    @Test
    public void testEmptyCredentialsNoUsername(){

    loginPage.enterPassword("iam_a_password");
    loginPage.clickLogin();
    var errorMessageDiv = loginPage.getErrorMessageDiv();
    assertTrue(errorMessageDiv.isDisplayed());
    assertEquals(errorMessageDiv.getText(),
            "Epic sadface: Username is required"
            ,"Error message text in div mismatch" );

    }
/* Testing login while entering username and leaving
   password empty and verifying that the div for the error
   message is visible and contains text that matches the text
   that would be displayed when attempting to log in with no password
 */
    @Test
    public void testEmptyCredentialsNoPassword(){
    loginPage.enterUsername("iam_a_username");
    loginPage.clickLogin();
    var errorMessageDiv = loginPage.getErrorMessageDiv();
    assertTrue(errorMessageDiv.isDisplayed());
    assertEquals(errorMessageDiv.getText(),
            "Epic sadface: Password is required",
            "Error message text in div mismatch");
    }
}
