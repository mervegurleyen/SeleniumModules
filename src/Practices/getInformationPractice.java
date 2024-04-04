package Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class getInformationPractice {

    public static void main(String[] args) {

//Navigate to 'https://www.saucedemo.com/'.

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com");

//Locate the username and password fields and the login button to log in to the system.
// Use standard user credentials provided on the website or as part of the exercise context.
        WebElement userNameInput=driver.findElement(By.id("user-name"));
        WebElement passwordInput=driver.findElement(By.id("password"));
        WebElement LoginButton=driver.findElement(By.id("login-button"));

       final String username="standard_user";
       final String password="secret_sauce";

        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        LoginButton.click();

      //  Expected Constants
        final String EXPECTED_PAGE_HEADER = "Products";
        final int EXPECTED_ITEMS_COUNT = 6;
        final String EXPECTED_ATC_TEXT_COLOR = "rgba(19, 35, 34, 1)"; // ATC - ADD TO CART
        final String EXPECTED_ATC_BORDER_COLOR = "rgb(19, 35, 34)"; // ATC - ADD TO CART
        final String EXPECTED_REMOVE_BUTTON_TEXT_COLOR = "rgba(226, 35, 26, 1)";
        final String EXPECTED_REMOVE_BUTTON_BORDER_COLOR = "rgb(226, 35, 26)";
        final String EXPECTED_REMOVE_BUTTON_TEXT = "Remove";


//        Verify the presence of the page header element with expected text - "Products".
//        Print in the console: Verify Page Header: PASSED or FAILED.

        String actualHeader=driver.findElement(By.xpath("//span[@class='title']")).getText();
        System.out.println("Successfully Logged In. Page header: " + actualHeader);

        if (EXPECTED_PAGE_HEADER.equals(actualHeader)){
            System.out.println("Verify Page Header: PASSED");
        }
        else {
            System.out.println("Verify Page Header: FAILED");
        }

            //Ensure there are exactly six items listed in the inventory section.
            //Print in the console: Verify Items Count: PASSED or FAILED.
        List<WebElement> itemsCount=driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
        int countItem=itemsCount.size();
        if (countItem==EXPECTED_ITEMS_COUNT){
            System.out.println("Verify Items Count: PASSED");
        }
        else {
            System.out.println("Verify Items Count: FAILED");
        }

            //Check if  "Sauce Labs Bike Light" is present on the page.
            //Print in the console: Verify 'Sauce Labs Bike Light' Presence: PASSED or FAILED.
        List<WebElement> BikeLightPresent=driver.findElements(By.xpath("//a[@id='item_0_title_link']"));
        boolean isPresentBikeLight=BikeLightPresent.size()>0;

        if (isPresentBikeLight==true){
            System.out.println("Verify 'Sauce Labs Bike Light' Presence: PASSED");
        }
        else {
            System.out.println("Verify 'Sauce Labs Bike Light' Presence: FAILED");
        }

        //Verify that the "ADD TO CART" button for "Sauce Labs Bolt T-Shirt" is visible(displayed), and enabled on the page.
        //Print in the console: Verify "ADD TO CARD" button Displayed and Enabled: PASSED or FAILED.
        // ADD TO CART (ATC) Button Displayed and Enabled State */
        WebElement sauceLabsBoltTShirtButton = driver.findElement(By.xpath("//*[text() = 'Sauce Labs Bolt T-Shirt']/../../..//button"));
        if(sauceLabsBoltTShirtButton.isDisplayed() && sauceLabsBoltTShirtButton.isEnabled()){
            System.out.println("- Verify \"ADD TO CARD\" button Displayed and Enabled: PASSED");
        } else {
            System.out.println("- Verify \"ADD TO CARD\" button Displayed and Enabled: FAILED");
        }
        // Verify ADD TO CART Button CSS Properties: */
//        atc - add to cart
        String atcTextColor = sauceLabsBoltTShirtButton.getCssValue("color");
        String atcBorder = sauceLabsBoltTShirtButton.getCssValue("border");
        String atcBorderColor = atcBorder.substring(atcBorder.indexOf("rgb"));

        /* Verify Button Text Color */
        if(EXPECTED_ATC_TEXT_COLOR.equals(atcTextColor)){
            System.out.println("- Verify Button Text Color: PASSED");
        } else {
            System.out.println("- Verify Button Text Color: FAILED");
        }

        /* Verify Button Border Color */
        if(EXPECTED_ATC_BORDER_COLOR.equals(atcBorderColor)){
            System.out.println("- Verify Button Border Color: PASSED");
        } else {
            System.out.println("- Verify Button Border Color: FAILED");
        }

        /* Interact with Button and Verify Changes */
        sauceLabsBoltTShirtButton.click();
        System.out.println("Clicked 'ATT TO CART' button.");

       //  relocate the button to avoid stale element exception after we interact with the element
        sauceLabsBoltTShirtButton = driver.findElement(By.xpath("//*[text() = 'Sauce Labs Bolt T-Shirt']/../../..//button"));
        String sauceLabsBoltTShirtButtonText = sauceLabsBoltTShirtButton.getText();
        System.out.println("Current button displayed text: " + sauceLabsBoltTShirtButtonText);

        /* Verify Button Text */
        if(EXPECTED_REMOVE_BUTTON_TEXT.equals(sauceLabsBoltTShirtButtonText)){
            System.out.println("- Verify Button Text: PASSED.");
        } else {
            System.out.println("- Verify Button Text: FAILED.");
        }

        /* Extract the css values from the button after click */
        String rmButtonTextColor = sauceLabsBoltTShirtButton.getCssValue("color");
        String rmButtonBorder = sauceLabsBoltTShirtButton.getCssValue("border");
        String rmButtonBorderColor = rmButtonBorder.substring(rmButtonBorder.indexOf("rgb"));

        /* Verify Button Text Color */
        if(EXPECTED_REMOVE_BUTTON_TEXT_COLOR.equals(rmButtonTextColor)){
            System.out.println("- Verify Button Text Color: PASSED");
        } else {
            System.out.println("- Verify Button Text Color: FAILED");
        }

        /* Verify Button Border Color */
        if(EXPECTED_REMOVE_BUTTON_BORDER_COLOR.equals(rmButtonBorderColor)){
            System.out.println("- Verify Button Border Color: PASSED");
        } else {
            System.out.println("- Verify Button Border Color: FAILED");
        }

        /* Cart Verification */
        WebElement cartButton = driver.findElement(By.cssSelector(".shopping_cart_link"));
        cartButton.click();
        System.out.println("Clicked Cart button.");

        /* Cart Page Actions */
        List<WebElement> allCartProducts = driver.findElements(By.cssSelector(".cart_item"));
        System.out.println("Items in the cart: " + allCartProducts.size());

//         /* Cart Page Actions */
        List<WebElement> allCartProductss = driver.findElements(By.cssSelector(".cart_item"));
        System.out.println("Items in the cart: " + allCartProducts.size());

        /* Verify items count in cart */
        if(allCartProductss.size() == 1){
            System.out.println("- Verify Cart Items: PASSED");
        } else {
            System.out.println("- Verify Cart Items: FAILED");
        }

        driver.quit();
    }
}

