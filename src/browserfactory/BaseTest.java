package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    //make driver as a WebDriver static variable to access throughout the class
 public static WebDriver driver;

 // make parameterized (baseUrl) method to open Url throughout the package by extending
 public void setUpBrowser(String baseUrl){
     // set property to open browser
     System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
     // opening browser
     driver = new ChromeDriver();
     //Launch Url
     driver.get(baseUrl);// pass baseUrl
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
 }
 public void closeBrowser(){

     driver.quit();
 }

}
