package ru.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

/**
 * Created by xxmoised on 07.10.2016.
 */


public class ApplicationManager {
    WebDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupsHelper;
    private ContactHelper contactsHelper;
    private String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }

    public static boolean isAlertPresent(ChromeDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
    public GroupHelper group() {
        return groupsHelper;
    }
    public ContactHelper contact() {
        return contactsHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }
    public void stop() {
        wd.quit();
    }

    public void init() {

        {
            if (browser.equals(BrowserType.FIREFOX)) {
                wd = new FirefoxDriver();
            } else if (browser.equals(BrowserType.CHROME)) {
                wd = new ChromeDriver();
            }
            else if (browser.equals(BrowserType.IE)) {
                wd = new InternetExplorerDriver();
            }
        }
        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get("http://localhost:8080/addressbook/group.php");
        groupsHelper = new GroupHelper(wd);
        contactsHelper = new ContactHelper(wd);
        navigationHelper = new NavigationHelper(wd);
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


}
