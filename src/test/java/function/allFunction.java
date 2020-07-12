package function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.How;

import java.util.List;

import static common.commonFunction.*;

public class allFunction {
    public static void main(String args[]) throws InterruptedException {
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
        backPrevious();
        backPrevious();

        click(How.XPATH, "//a[.='Broken Images']");
        for(WebElement e : imagelist(How.TAG_NAME, "img"))
        {
            isImageBroken(e);
        }
        backPrevious();
        //waiting(2000);

        click(How.XPATH,"//a[.='Checkboxes']");
        click(How.XPATH,"//input[@type='checkbox'][1]");
        click(How.XPATH,"//input[@type='checkbox'][2]");
        backPrevious();

/*      click(How.XPATH, "//a[.='Context Menu']");
        rightClick(How.ID, "hot-spot");
        navigateHomePage();*/

        click(How.XPATH, "//a[.='Digest Authentication']");
        visit("https://admin:admin@the-internet.herokuapp.com/digest_auth");
        backPrevious();
        backPrevious();

        click(How.XPATH, "//a[.='Drag and Drop']");
        dragAndDrop(getElement(How.ID, "column-a"),getElement(How.ID, "column-b"));
        backPrevious();

        click(How.XPATH, "//a[.='Dropdown']");
        dropDownList("Option 2");
        backPrevious();

        click(How.XPATH, "//a[.='Dynamic Controls']");
        // brand 1





    }



}
