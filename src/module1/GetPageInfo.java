package module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class GetPageInfo {

    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        String url="http://dev-hrm.yoll.io/";
        driver.get(url);

        String title=driver.getTitle();
        System.out.println("Page title: "+title);

        String currentUrl=driver.getCurrentUrl();
        System.out.println("Actual url: "+ currentUrl);

        driver.quit();


    }
}
