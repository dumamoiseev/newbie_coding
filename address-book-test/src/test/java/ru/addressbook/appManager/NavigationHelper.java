package ru.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by xxmoised on 07.10.2016.
 */
public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {

       super(wd);
    }

    public void groupPage()  {
        click(By.linkText("groups"));
    }

    public void gotoHomePage()
    {
        if (isElementPresent(By.id("manintable"))) {
        return;
    }
        click(By.linkText("home page"));
    }
}
