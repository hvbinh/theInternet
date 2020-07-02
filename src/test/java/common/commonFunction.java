package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.How;

public class commonFunction {
    static WebDriver driver;
    public static WebDriver getDriver()
    {
        return  driver;
    }
    public static void openBrowsers(String browserName)
    {

        switch (browserName.toLowerCase())
        {
            case "chrome":
            {
                System.setProperty("webdriver.chrome.driver","src/test/java/browsers/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            }
            case "firefox":
            {
                System.setProperty("webdriver.gecko.driver","src/test/java/browsers/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            }
            default:
            {
                throw new IllegalStateException("undefine"+ browserName);
            }
        }
    }
    public static void visit(String url)
    {
        driver.get(url);
    }
    public static WebElement getElement(How by, String locator)
    {
        return driver.findElement(by.buildBy(locator));
    }
    public static void click(How by, String locator)
    {
        getElement(by, locator).click();
    }
    public static void backPrevious()
    {
        driver.navigate().back();
    }



}
