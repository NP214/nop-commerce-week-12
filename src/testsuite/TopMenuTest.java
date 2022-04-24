package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com";

    @Before
    public void openBrowser() {
        setUpBrowser(baseUrl);
        clickOnElement(By.xpath("//a[@class='ico-login']"));
       sendTextToElement((By.id("Email")),"nidhiprime214@gmail.com");

      sendTextToElement((By.id("Password")),"Nidhi123");

        clickOnElement(By.xpath("//button[@class='button-1 login-button']"));

    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        //click on computer on topmenu
       clickOnElement((By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]")));
      //validate text
     verifyTextWithAssert("Computers",By.xpath(("//h1[contains(text(),'Computers')]")),"Text is not displayed");

    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        // clicks on Electronics
       clickOnElement((By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]")));
        verifyTextWithAssert("Electronics",By.xpath(("//h1[contains(text(),'Electronics')]")),"Text is not displayed");
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        clickOnElement((By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]")));
        verifyTextWithAssert("Apparel",By.xpath(("//h1[contains(text(),'Apparel')]")),"Text is not displayed");

    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[4]/a[1]")).click();
        verifyTextWithAssert("Digital downloads",By.xpath(("//h1[contains(text(),'Digital downloads')]")),"Text is not displayed");

    }
    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[5]/a[1]")).click();
        verifyTextWithAssert("Books",By.xpath(("//h1[contains(text(),'Books')]")),"Text is not displayed");

    }
    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[6]/a[1]")).click();
        verifyTextWithAssert("Jewelry",By.xpath(("//h1[contains(text(),'Jewelry')]")),"Text is not displayed");

    }
    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]")).click();
        verifyTextWithAssert("Gift Cards",By.xpath(("//h1[contains(text(),'Gift Cards')]")),"Text is not displayed");
      
    }
    @After
    public void close(){
        closeBrowser();
    }
}
