package Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class webShopDemo {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
//        Navigate to http://demowebshop.tricentis.com

        driver.get("http://demowebshop.tricentis.com");

//        Locate below elements using XPATH
//          1. Logo (Demo Web Shop)
        WebElement logo=driver.findElement(By.xpath("//img[@src='/Themes/DefaultClean/Content/images/logo.png']"));

//        $25 Virtual Gift Card:
        WebElement giftCard=driver.findElement(By.xpath("//a[text()='$25 Virtual Gift Card']"));

//        Wishlist(0)
        WebElement wishList=driver.findElement(By.xpath("//span[text()='Wishlist']"));

        //Register
        WebElement register=driver.findElement(By.xpath("//a[text()='Register']"));

        //Search
        WebElement searchButton=driver.findElement(By.xpath("//input[@class='button-1 search-box-button']"));

        //Search TextBox
        WebElement searchTextBox=driver.findElement(By.xpath("//input[@class='search-box-text ui-autocomplete-input']"));


        WebElement price=driver.findElement(By.xpath("//div[@data-productid='74']//div[@class='prices']//span"));

        List<WebElement> numberofItems=driver.findElements(By.xpath("//div[@class='item-box']"));
        numberofItems.size();

        List<WebElement> numberofItems2=driver.findElements(By.xpath("//div[@class='listbox']"));
        numberofItems2.size();

        List<WebElement> customerServiceList=driver.findElements(By.xpath("//div[@class='column customer-service']//ul//li']"));
        customerServiceList.size();

        //ul[@class='top-menu']//li

        List<WebElement> topMenu=driver.findElements(By.xpath("  //ul[@class='top-menu']//li"));
   topMenu.size();

    }


}
