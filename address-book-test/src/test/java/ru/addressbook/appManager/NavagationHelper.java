package ru.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by xxmoised on 07.10.2016.
 */
public class NavagationHelper extends HelperBase {

    public NavagationHelper(WebDriver wd) {

       super(wd);
    }

    public void gotoPageGroup()  {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("groups")
                && isElementPresent(By.name("new"))) {
            return;
        }
        click(By.name("groups"));
    }
    public void gotoHomePage()
    {
        if (isElementPresent(By.id("manintable"))) {
        return;
    }
        click(By.linkText("home page"));
    }
}
