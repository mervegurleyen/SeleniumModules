package Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownPractice2 {

    public static void main(String[] args) {


        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://demo.automationtesting.in/Register.html");

//        Identify the dropdown element for "Day" on the registration form.

        WebElement dayDropdown=driver.findElement(By.xpath("//select[@placeholder='Day']"));
        Select dayDropdownOptions=new Select(dayDropdown);


//        Retrieve all available options from the "Day" dropdown.
//Iterate through the retrieved list and print each options text to the console.

        List<WebElement> allOptions=dayDropdownOptions.getOptions();
        for (WebElement elem:allOptions){
            System.out.println(elem.getText());
        }

//        Use the selectByVisibleText() method to select a specific day from the dropdown options
        dayDropdownOptions.selectByVisibleText("11");

//        After selection, use the getFirstSelectedOption() method to retrieve the currently selected option.
//Print the selected day to the console in the format: 'Selected Day: ', replacing with the actual day selected.
        String getFirstSelectedOption=dayDropdownOptions.getFirstSelectedOption().getText();
            System.out.println("Selected Day: "+ getFirstSelectedOption);

            driver.quit();

    }
}
