package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.appManager.HelperBase;

/**
 * Created by xxmoised on 15.10.2016.
 */
public class DeleteContactTest extends TestBase {

    @Test
    public void testDeleteContact() {
        app.getGroupsHelper().ContactPage();
        app.getGroupsHelper().selectContact();
        app.getGroupsHelper().initDeleteContact();
        app.getGroupsHelper().acceptDeleteContact();
        //app.getGroupsHelper().confirmDeleteContact();
    }

    private HelperBase switchTo() {
        return null;
    }
}
