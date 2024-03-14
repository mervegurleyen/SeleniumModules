package module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Guru99Practice {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver=new ChromeDriver();

        driver.get("https://demo.guru99.com/test/newtours/");
        String username="test@email.com";
        String password="test";

        driver.findElement(By.name("userName")).sendKeys(username);
        Thread.sleep(100);

        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(100);

        driver.findElement(By.name("submit")).click();

        driver.findElement(By.partialLinkText("Vacations"));
        Thread.sleep(100);

        driver.findElement(By.partialLinkText("REGISTER"));
        Thread.sleep(100);

        driver.quit();

    }
}


//Go to http://demo.guru99.com/test/newtours/
//Fill out username and password using Name locator
//Username: test@email.com
//Password: test
//Click on submit button
//Click on Vacations link using partialLinktext locator
//Then wait for 10 seconds
//Click on Register link using linkText locator
//Then wait for 10 seconds
//Close completely the webDriver instance