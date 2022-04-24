package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.Random;

public class RegisterTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com";

    @Before
    public void openBrowser() {
        setUpBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToRegisterPageSuccessfully(){
        //navigate to "register" and click on it\
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        // validate text
        verifyTextWithAssert("Register",By.xpath("//h1[contains(text(),'Register')]"),"text not displayed");

    }
    @Test
    public void userSholdRegisterAccountSuccessfully(){
        // click on register link
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
//Select gender radio button
        clickOnElement(By.xpath("//input[@id='gender-female']"));
//Enter First name
        sendTextToElement(By.xpath("//input[@id='FirstName']"),"Nidhi");

//Enter Last name
        sendTextToElement(By.xpath("//input[@id='LastName']"),"patel");

//Select Day Month and Year
        selectByIndexFromDropDown((By.xpath("//select[@name='DateOfBirthDay']")),21);
        selectByValueFromDropdown((By.xpath("//select[@name='DateOfBirthMonth']")),"4");
      selectByVisibleTextFromDropDown((By.xpath("//select[@name='DateOfBirthYear']")),"1992");

//Enter Email address
      WebElement email = driver.findElement((By.xpath("//input[@id='Email']")));
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        email.sendKeys("username" + randomInt + "@gmail.com");
//Enter Password
        sendTextToElement((By.xpath("//input[@id='Password']")),"nidhi123");
        sendTextToElement((By.xpath("//input[@id='ConfirmPassword']")),"nidhi123");

        clickOnElement(By.id("register-button"));
        verifyTextWithAssert("Your registration completed",By.xpath(("//div[contains(text(),'Your registration completed')]")),"text not displayed");
    }
    @After
    public void quitBrowser(){
        closeBrowser();
    }

}
