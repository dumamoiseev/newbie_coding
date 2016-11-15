package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.appManager.HelperBase;
import ru.addressbook.model.ContactData;
import ru.addressbook.model.Contacts;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by xxmoised on 15.10.2016.
 */
public class ContactDeleteTests extends TestBase {

    @Test
    public void testDeleteContact() {
        app.contact().ContactPage();
             Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();

        //if (! app.group().isTherecontact()) {
          //  app.group().createContact(new ContactData("dmitry", "Pavlovich", "Moiseev", null, "Horoshaya", null, "723423424234", "DMITRY.moiseev@pochta.com ", "12312312313289080809"), true);
            //app.goTo().gotoHomePage();
            app.contact().deleteContact(deletedContact);
            app.contact().ContactPage();
        Assert.assertEquals(app.contact().count(), before.size() - 1);
        Contacts after = app.contact().all();


            before.remove(deletedContact);
        assertThat(after, equalTo(
                before.without(deletedContact)));

    }

    private HelperBase switchTo() {
        return null;
    }
}
