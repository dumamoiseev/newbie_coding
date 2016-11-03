package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.appManager.HelperBase;
import ru.addressbook.model.contactData;

/**
 * Created by xxmoised on 15.10.2016.
 */
public class DeleteContactTest extends TestBase {

    @Test
    public void testDeleteContact() {
        app.getGroupsHelper().ContactPage();
        if (! app.getGroupsHelper().isTherecontact())
        {app.getGroupsHelper().createContact(new contactData("dmitry", "Pavlovich", "Moiseev",null , "Horoshaya", null, "723423424234", "DMITRY.moiseev@pochta.com ", "12312312313289080809"), true);app.getNavagationHelper().gotoHomePage();
        app.getGroupsHelper().selectContact();
        app.getGroupsHelper().initDeleteContact();
        app.getGroupsHelper().acceptDeleteContact();
        //app.getGroupsHelper().confirmDeleteContact();
    }
}
    private HelperBase switchTo() {
        return null;
    }
}
