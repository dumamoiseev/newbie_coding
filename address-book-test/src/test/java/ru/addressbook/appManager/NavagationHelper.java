package ru.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by xxmoised on 07.10.2016.
 */
public class NavagationHelper extends HelperBase {

    public NavagationHelper(FirefoxDriver wd) {

       super(wd);
    }

    public void gotoPageGroup() {
        wd.findElement(By.name("new")).click();
    }

    public void gotoHomePage() {
        click(By.linkText("home page"));
    }
}
