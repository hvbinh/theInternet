package function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.How;

import static common.commonFunction.*;

public class allFunction {
    public static void main(String args[])
    {
        openBrowsers("chrome");
        visit("https://the-internet.herokuapp.com");
        click(How.XPATH,"//a[.='A/B Testing']");
        backPrevious();

        click(How.XPATH,"//a[.='Add/Remove Elements']");
        click(How.XPATH,"//button[.='Add Element']");
        click(How.XPATH,"//button[.='Add Element']");
        click(How.XPATH,"//button[.='Delete'][1]");
        click(How.XPATH,"//button[.='Delete']");
        backPrevious();

        click(How.XPATH,"//a[.='Basic Auth']");
        visit("https://admin:admin@the-internet.herokuapp.com/basic_auth");


    }

}
