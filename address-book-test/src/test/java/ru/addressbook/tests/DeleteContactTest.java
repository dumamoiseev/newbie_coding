package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.appManager.HelperBase;
import ru.addressbook.model.contactData;

import java.util.List;

/**
 * Created by xxmoised on 15.10.2016.
 */
public class DeleteContactTest extends TestBase {

    @Test
    public void testDeleteContact() {
        app.getGroupsHelper().ContactPage();
             List<contactData> before = app.getGroupsHelper().getContactList();
        //if (! app.getGroupsHelper().isTherecontact()) {
          //  app.getGroupsHelper().createContact(new contactData("dmitry", "Pavlovich", "Moiseev", null, "Horoshaya", null, "723423424234", "DMITRY.moiseev@pochta.com ", "12312312313289080809"), true);
            //app.getNavagationHelper().gotoHomePage();
            app.getGroupsHelper().selectContact();
            app.getGroupsHelper().initDeleteContact();
            app.getGroupsHelper().acceptDeleteContact();
            app.getGroupsHelper().ContactPage();
            List<contactData> after = app.getGroupsHelper().getContactList();
            Assert.assertEquals(after.size(),before.size()-1);

            before.remove(before.size() -1);
            Assert.assertEquals(before, after);

    }

    private HelperBase switchTo() {
        return null;
    }
}
