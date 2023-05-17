package demoConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Config {
    static WebDriver driver = null;
    public static String getURL = "https://www.provet.cloud/request-demo";
    public static By btn_getCookieID = By.id("hs-eu-confirmation-button");
    public static By txt_getFirstName = By.xpath("//input[@name=\"firstname\"]");
    public static By txt_getLastName = By.xpath("//input[@name=\"lastname\"]");
    public static By txt_getCompanyName = By.xpath("//input[@name=\"company\"]");
    public static By txt_getEmail = By.xpath("//input[@name=\"email\"]");
    public static By txt_getPhoneName = By.xpath("//input[@name=\"phone\"]");
    public static By txt_getJobTitle = By.xpath("//input[@name=\"jobtitle\"]");
    public static By drpdwn_getCountryDropdown = By.name("country__dropdown_");
    public static By chk_accept = By.xpath("//*[@class='legal-consent-container']//child::li[contains(@class,'hs-form-booleancheckbox')]");
    public static By btn_submit = By.xpath("(//*[@class='actions']//child::input)[1]");
    public static By lbl_subscription = By.xpath("//*[contains(text(),'Subscribe to our newsletter')]");

    public static WebDriver initiate_Webdriver() {
        System.setProperty("webdriver.http.factory", "jdk-http-client"); // set System property to handle remote http connection
        WebDriverManager.chromedriver().setup(); // using WebDriverManager to handle though for any chrome version
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Config.getURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Config.elementTobeclickable(btn_getCookieID);
        return driver;
    }

    public static void chk_demorequest_success() {
        if(driver.findElement(Config.lbl_subscription).isDisplayed())
            Assert.assertEquals(driver.findElement(Config.lbl_subscription).getText(),"Subscribe to our newsletter", "User submitted a demo request");
    }
    public static void terminate_driver() {
        driver.manage().deleteAllCookies();
        driver.quit();    // Once all tests executed then terminate driver and close all sessions
        System.out.println("Web Driver terminated successfully");
    }
    public static void elementTobeclickable (By elem) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        if (driver.findElement(elem).isEnabled()) {
            wait.until(ExpectedConditions.elementToBeClickable(elem));
            driver.findElement(elem).click();
        }
    }
    public static void click_btn(By element){
        driver.findElement(element).click();
    }
}
