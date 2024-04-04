package Practices;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownPractice1 {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://demo.automationtesting.in/Register.html");

//        Identify the dropdown element for "Month" on the registration form.

        WebElement months=driver.findElement(By.xpath("//select[@placeholder='Month']"));
        Select monthDropdown=new Select(months);
//        Implement a loop to iterate through each option in the "Month" dropdown.
//          For each iteration, print the name of the month to the console.
//      Detect DOB Month:
//          During iteration, compare each month with the predefined DOB month
        String expectedMonth="July";
        List <WebElement> listOfMonths=monthDropdown.getOptions();

        for (WebElement elem:listOfMonths){
            if (elem.getText().equals("July")){
                break;
            }
            System.out.println(elem.getText());
        }
        driver.quit();
    }
}
