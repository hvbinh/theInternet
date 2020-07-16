package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
    public static List<WebElement> imagelist(How by, String locator)
    {
        return driver.findElements(by.buildBy(locator));
    }
    public static void isImageBroken(WebElement image)
    {
        if (image.getAttribute("naturalWidth").equals("0"))
        {
            System.out.println(image.getAttribute("outerHTML") + " is broken.");
        }
    }
    public static void waiting(long var) throws InterruptedException {
        driver.manage().window().wait(var);
    }
    public static void rightClick(How by, String locator)
    {
        Actions action = new Actions(driver);
        action.contextClick(getElement(by,locator)).perform();
    }
    public static void refreshPage()
    {
        driver.navigate().refresh();
    }
    public static void navigateHomePage()
    {
        driver.navigate().to("https://the-internet.herokuapp.com");
    }
    public static void dragAndDrop(WebElement a, WebElement b)
    {
        Actions action = new Actions(driver);
        action.dragAndDrop(a, b).perform();
    }
    public static void dropDownList(String name)
    {
        Select sel = new Select(getElement(How.ID, "dropdown"));
        sel.selectByVisibleText(name);
    }
    public static void waiting(WebElement e) throws InterruptedException {
        e.click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
        backPrevious();
        backPrevious();

    }
    public static void hardWaiting()
    {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }




}
