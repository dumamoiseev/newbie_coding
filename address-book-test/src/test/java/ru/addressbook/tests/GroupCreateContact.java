package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.contactData;

public class GroupCreateContact extends TestBase {


    @Test
    public void createContact() {
        app.getGroupsHelper().initCreationContact();
        app.getGroupsHelper().fillFormContact(new contactData("pavel", "Pavlovich", "Moiseev", "newbieCoder", "Horoshaya", "SPB", "723423424234", "DMITRY.moiseev@pochta.com"));
        app.getGroupsHelper().submitCreationContact();
        app.getNavagationHelper().gotoHomePage();
    }


}