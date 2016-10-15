package ru.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.addressbook.appManager.ApplicationManager;

/**
 * Created by xxmoised on 04.10.2016.
 */
public class TestBase {

    public final ApplicationManager app = new ApplicationManager();

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }


}