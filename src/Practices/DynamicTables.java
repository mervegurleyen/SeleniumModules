package Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DynamicTables {


    public static void main(String[] args) {


        WebDriver driver=new ChromeDriver();

//        Navigate to the URL: 'https://practice.expandtesting.com/dynamic-table'.
        driver.get("https://practice.expandtesting.com/dynamic-table");

//        Capture and Display Page Title:

        String title=driver.getTitle();
        System.out.println("Page Title: "+title);

//        Develop a Dynamic Locator for Chrome CPU:
//        Recognize that the positions of rows and columns in the table change with each page refresh.
//-       Devise a strategy to dynamically locate the CPU value for the Chrome browser each time,
//        ensuring the value is directly retrieved from the table.

        List<WebElement> columnHeaders= driver.findElements(By.xpath("//table//th"));
        int cPuColumnPosition=-1;

        for (int i=0; i<columnHeaders.size(); i++){
            String CurrentHeaderName= columnHeaders.get(i).getText();
            if ("CPU".equals(CurrentHeaderName)){
                cPuColumnPosition=i+1;
                break;
            }

        }

        String chromeCpuXpath="//table//td[text()='Chrome'/../td["+cPuColumnPosition+"]";
        String actualChromeCpu=driver.findElement(By.xpath(chromeCpuXpath)).getText();
        System.out.println("Actual Chrome CPU: "+actualChromeCpu);

        String expectedChromeCpu=driver.findElement(By.id("chrome-cpu")).getText();
        System.out.println("Expected Chrome CPU= "+expectedChromeCpu);

        if (expectedChromeCpu.equals(actualChromeCpu)
        ) {
            System.out.println("TEST: PASSED");
        }
        else {
            System.out.println("TEST: FAILED");
        }

        driver.quit();

    }

    }

