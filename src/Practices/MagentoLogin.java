package Practices;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.TreeMap;

public class MagentoLogin {

    public static void main(String[] args) throws InterruptedException {

        String UN="testautoman@email.com";
        String PW="qwerty123!";

        WebDriver driver=new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");

//        Click sign-in button on homepage - use xpath as a locator strategy
        WebElement LoginLink=driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));

//        Enter your email  - use xpath as a locator strategy.
//        Enter your pwd  - use xpath as a locator strategy.
//        Click signin button  - use xpath as a locator strategy.

        LoginLink.click();

        Thread.sleep(500);

        WebElement userNameInput=driver.findElement(By.xpath("//input[@id='email']"));
        WebElement PasswordInput=driver.findElement(By.xpath("//input[@name='login[password]']"));
        WebElement SigninButton=driver.findElement(By.xpath("//button[@class='action login primary']"));

        userNameInput.sendKeys(UN);
        PasswordInput.sendKeys(PW);
        SigninButton.click();

//        Print Title of the page to verify you successfully signed in.

        Thread.sleep(5000);
        System.out.println(driver.getTitle());

//        Print Welcome Message

        String welcomeMessage=driver.findElement(By.xpath("//li[@class='greet welcome'][1]")).getText();

        if (welcomeMessage.startsWith("Welcome")){
            System.out.println("TEST: PASSED");
        }
        else{
            System.out.println("TEST: FAILED");
        }


        driver.quit();











    }
}
