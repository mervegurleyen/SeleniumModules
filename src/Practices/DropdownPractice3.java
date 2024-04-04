package Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownPractice3 {

    public static void main(String[] args) {


        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.jqueryscript.net/demo/jQuery-Multiple-Select-Plugin-For-Bootstrap-Bootstrap-Multiselect/");

//        Retrieve all available options from the third dropdown.
//Iterate through the retrieved list and print each options text to the console.

      driver.findElement(By.xpath("//*[@id='example27']/..//button")).click();

        List<WebElement> listofAllOptions=driver.findElements(By.xpath("//*[@id='example27']/..//label"));
        for (WebElement elem: listofAllOptions){
            System.out.println(elem.getText());
        }

        driver.findElement(By.xpath("//*[@id='example27']/..//label[contains(text(),'Python')]/input")).click();
        driver.findElement(By.xpath("//*[@id='example27']/..//label[contains(text(),'Ruby')]/input")).click();

        listofAllOptions=driver.findElements(By.xpath("//*[@id='example27']/..//li"));

        System.out.println("Selected Options : ");

        for (WebElement elem:listofAllOptions){
            if (elem.getAttribute("class").equals("active")){
                System.out.println(elem.getText());
            }
        }
        driver.quit();
    }
}
