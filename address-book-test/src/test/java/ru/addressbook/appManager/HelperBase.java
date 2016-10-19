package ru.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.xml.ISuiteParser;

/**
 * Created by xxmoised on 11.10.2016.
 */
public class HelperBase {
    protected WebDriver wd;

    public HelperBase(WebDriver wd)
    {
        this.wd = wd;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(By locator, String text) {
      click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }


    public ISuiteParser alert() {
        return null;
    }
}
