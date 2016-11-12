package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.contactData;
import ru.addressbook.model.dataGroup;

import java.util.List;

public class GroupCreateContact extends TestBase {


    @Test
    public void createContact() {
        app.getGroupsHelper().ContactPage();
        List<contactData> before = app.getGroupsHelper().getContactList();
        app.getGroupsHelper().initCreationContact();
        contactData contact = new contactData("Dmitry", "Pavlovich", "Moiseev", "newbieCoder", "Horoshaya", "SPB", "723423424234", "DMITRY.moiseev@pochta.com", null);
        app.getGroupsHelper().fillFormContact(contact, true);
        app.getGroupsHelper().submitCreationContact();
        app.getNavagationHelper().gotoHomePage();
        List<contactData> after = app.getGroupsHelper().getContactList();

        Assert.assertEquals(after.size(),before.size()+ 1);
        int max = 0;
        for (contactData c : after) {
            if (c.getIdC() > max){
                max = c.getIdC();
            }
        }
        contact.setIdC(max);
        before.add(contact);
        Assert.assertEquals(before,after);
    }


}
