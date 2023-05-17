package bookademo;
import demoConfig.Config;
import demoConfig.allGetters;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookRequest extends Config {
    static WebDriver driver = null;
    @BeforeTest
    public static void BookRequest( ) throws InterruptedException {
        driver = Config.initiate_Webdriver(); //  new Chrome Driver object will invoke chrome browser and assign to local driver
    }
    @Test
    public static void SubmitDemo() {
        System.out.println("My first Test case. Booking a demo ");
        try {
        allGetters getTestData = new allGetters();
        driver.findElement(Config.txt_getFirstName).sendKeys(getTestData.getfirstName());
            driver.findElement(Config.txt_getLastName).sendKeys(getTestData.getlastName());
            driver.findElement(Config.txt_getCompanyName).sendKeys(getTestData.getccompanyName());
            driver.findElement(Config.txt_getEmail).sendKeys(getTestData.getEmailAddress());
            driver.findElement(Config.txt_getPhoneName).sendKeys(getTestData.getPhoneNumber());
            driver.findElement(Config.txt_getJobTitle).sendKeys(getTestData.getJobTitle());
            WebElement selectCountryListbox = driver.findElement(Config.drpdwn_getCountryDropdown);
            Select countryName = new Select(selectCountryListbox);
            countryName.selectByVisibleText(getTestData.getCountryName());
            click_btn(Config.chk_accept);
            click_btn(Config.btn_submit);
            Thread.sleep(10000);
            Config.chk_demorequest_success();
        }
        catch(ElementNotInteractableException e){
            System.out.println("Element is not interactable");
            e.printStackTrace();
        }
        catch(Exception e){
           System.out.println("Browser is causing issue, reRun the test");
        }
    }
    @AfterTest
    public static void close_browser(){
        Config.terminate_driver();
    }
}
