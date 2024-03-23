package Practices;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class webTables {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();

        driver.get("https://practice.expandtesting.com/tables");

//        Print the Page Title as: 'Page Title: ' - replace with the actual title of the page.

        String title=driver.getTitle();
        System.out.println("Page Title: "+title);

        printEmailByFullName(driver,"Frank","Bach");

        double expectedAmount=251.0;
        double actualAmount= getTotalAmountOfDueColumn(driver);

        if (actualAmount==expectedAmount){
            System.out.println("Test: PASSED");
        }
        else {
            System.out.println("Test: FAILED");
        }

    }

//    Create a method named printEmailByFullName:

    public static void printEmailByFullName(WebDriver driver, String fName, String lName){
//  Build a dynamic XPath to identify a person's email based on the provided full name.
//        Print the email of the requested person.
        String getEmailXpath="//table[@id='table1']//td[text()='"+fName+"']/../td[text()='"+lName+"']/../td[3]";
        boolean itemPresent=!driver.findElements(By.xpath(getEmailXpath)).isEmpty();

        if(itemPresent){
            String value=driver.findElement(By.xpath(getEmailXpath)).getText();
            System.out.println(fName+" "+" "+lName+" E mail: "+ value);
        }
        else {
            System.out.println("No such a record found in table!");
        }
    }

    public static double getTotalAmountOfDueColumn(WebDriver driver){
        List<WebElement> pricesWebElements= driver.findElements(By.xpath("//table[@id='table1']//td[4]"));

        double totalAmount=0.0;

        for (WebElement prices:pricesWebElements){
            String priceText= prices.getText();
            double price=Double.parseDouble(priceText.substring(1));
            totalAmount=totalAmount+price;
        }

        return totalAmount;
    }
}
