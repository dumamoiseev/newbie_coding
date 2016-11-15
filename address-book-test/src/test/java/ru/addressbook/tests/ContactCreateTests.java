package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;
import ru.addressbook.model.Contacts;


import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreateTests extends TestBase {


    @Test
    public void createContact() {
        app.contact().ContactPage();
        Contacts before = app.contact().all();
        app.contact().initCreationContact();
        ContactData contact = new ContactData()
                .withFirstname("DMITRY")
                .withLastname("AFASEG")
                .withGroup("test1");
         app.contact().fillFormContact(contact,true);
        app.contact().submitCreationContact();
        app.goTo().gotoHomePage();
        Assert.assertEquals(app.contact().count(), before.size()+1);
        Contacts after = app.contact().all();

        assertThat(after, equalTo(
                before.withAdded(contact.withIdC(after.stream().mapToInt((g) -> g.getIdC()).max().getAsInt()))));
    }


}
