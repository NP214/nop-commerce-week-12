package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com";

    @Before
    public void openBrowser() {
        setUpBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
// click on LogIn link
        clickOnElement(By.xpath("//a[@class='ico-login']"));

// verify the message displayed on logIn page
// If u want to check how assert works, make expectedMsg text false..remove any thing from the below text

        verifyTextWithAssert("Welcome, Please Sign In!",By.xpath("//div[@class='master-wrapper-content']/div/div/div/div/h1"),"Text not found");
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //click on logIn
        clickOnElement(By.xpath("//a[@class='ico-login']"));
        sendTextToElement((By.id("Email")),"prime123@gmail.com");
        sendTextToElement((By.id("Password")),"prime123");
        clickOnElement((By.xpath("//button[@class='button-1 login-button']")));
   verifyTextWithAssert("Log out",(By.xpath("//a[contains(text(),'Log out')]")),"Massage not displayed");


    }
@Test
    public void verifyTheErrorMessage() {
        //click on logIn
    clickOnElement(By.xpath("//a[@class='ico-login']"));
        sendTextToElement(By.id("Email"),"prime123@gmail.com");
    sendTextToElement(By.id("Password"),"prime1234");
       clickOnElement(By.xpath("//button[@class='button-1 login-button']"));
       verifyTextWithAssert("Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect",By.xpath(("//div[@class='message-error validation-summary-errors']")),"message not displayed");
    }
    @After
    public void close(){

        closeBrowser();
    }

}
