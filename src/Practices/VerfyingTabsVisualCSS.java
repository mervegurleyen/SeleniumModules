package Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerfyingTabsVisualCSS {

    public static void main(String[] args) throws InterruptedException {

//        Launch a web browser and navigate to 'http://dev-hrm.yoll.io/'.
        WebDriver driver=new ChromeDriver();
        driver.get("http://dev-hrm.yoll.io/");

        //Locate username and password fields, locate login button. Enter these credentials:
        // username (yoll-student)
        // password (Bootcamp5#)
        //Click the login button to proceed.
        WebElement userNameInput=driver.findElement(By.id("txtUsername"));
        WebElement passwordInput=driver.findElement(By.id("txtPassword"));
        WebElement LoginButton=driver.findElement(By.id("btnLogin"));

        userNameInput.sendKeys("yoll-student");
        passwordInput.sendKeys("Bootcamp5#");
        LoginButton.click();

        Thread.sleep(5000);
        //Print on the console the title of the page.
        String titleOfthePage=driver.getTitle();
        System.out.println("Page title: "+titleOfthePage);

        //Locate the 'PIM' tab on the menu bar.
        WebElement pimTab=driver.findElement(By.id("menu_pim_viewPimModule"));

        //Print the background color of PIM tab.
        String colorCSS=pimTab.getCssValue("background-color");
        System.out.println("PIM tab background color before click: "+colorCSS);


    //Click on the 'PIM' tab to access the personal information management section.
        pimTab.click();

        pimTab=driver.findElement(By.id("menu_pim_viewPimModule"));
        System.out.println("PIM tab background color after click: "+colorCSS);
//Print the PIM tab's background color to ensure it visually reflects the current selection.
      driver.quit();
    }
}
