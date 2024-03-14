package Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.validation.Validator;

public class devHrmPractice {

    public static void main(String[] args) throws InterruptedException {

        //Acceptance Criteria
        //Given user navigate to http://dev-hrm.yoll.io/";
        //Then user enters username yoll-student
        //And user enters password Bootcamp5#
        //And user clicks on login button
        //Then prints the title
        //And the header page is "Dashboard"

        WebDriver driver=new ChromeDriver();

       // Go to url: http://dev-hrm-yoll.io/
        String url="http://dev-hrm.yoll.io/";
        driver.get(url);

        //Enter username: yoll-student
        //Enter password: Bootcamp5#

        String username="yoll-student";
        String password="Bootcamp5#";

        WebElement usernameInput=driver.findElement(By.xpath("//input[@id='txtUsername']"));
        WebElement passwordInput=driver.findElement(By.xpath("//input[@id='txtPassword']"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        //click login
        WebElement button=driver.findElement(By.cssSelector("input[id=btnLogin]"));
        button.click();

        Thread.sleep(5000);

        //Validate the title of the home page
        String title=driver.getTitle();
        System.out.println("The title of the page: "+title);

        //Validate that the page header is "dashboard"

        String expectedHeader="Dashboard";
        WebElement pageHeader=driver.findElement(By.xpath("//div[@class='head']//h1"));
System.out.println(pageHeader);
//        if (expectedHeader.equals(pageHeader)){
//            System.out.println("TEST: PASSED");
//        }else {
//            System.out.println("TEST: FAILED");
//        }

         driver.quit();

    }
}
