package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.contactData;
import ru.addressbook.model.dataGroup;

import java.util.List;

/**
 * Created by xxmoised on 15.10.2016.
 */
public class EditingContactTest extends TestBase {


@Test
public void testEditingContact() {
    app.getGroupsHelper().ContactPage();
    List<contactData> before = app.getGroupsHelper().getContactList();
    app.getGroupsHelper().pickToEditContact();
    app.getGroupsHelper().fillFormContact(new contactData("123123132", "Pavlovich", "Moiseev", "newbieCoder", "Horoshaya", "SPB", "723423424234", "DMITRY.moiseev@pochta.com", null), false );
    app.getGroupsHelper().confirmEditingContact();
    app.getGroupsHelper().ContactPage();
    List<contactData> after = app.getGroupsHelper().getContactList();
    Assert.assertEquals(after.size(),before.size());

        Assert.assertEquals(before, after);

    }
}
