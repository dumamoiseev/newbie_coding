package ru.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by xxmoised on 07.10.2016.
 */


public class ApplicationManager {
    FirefoxDriver wd;

    private SessionHelper sessionHelper;
    private NavagationHelper navagationHelper;
    private ContactAndGroupHelper groupsHelper;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void stop() {
        wd.quit();
    }

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost:8080/addressbook/group.php");
        groupsHelper = new ContactAndGroupHelper(wd);
        navagationHelper = new NavagationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    private void login(String username, String password) {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    public ContactAndGroupHelper getGroupsHelper() {
        return groupsHelper;
    }

    public NavagationHelper getNavagationHelper() {
        return navagationHelper;
    }
}
