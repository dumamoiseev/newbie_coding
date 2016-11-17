package ru.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.addressbook.appManager.ApplicationManager;

/**
 * Created by xxmoised on 04.10.2016.
 */
public class TestBase {

    public static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));


    @AfterSuite
    public void tearDown() {
        app.stop();
    }

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }


}
