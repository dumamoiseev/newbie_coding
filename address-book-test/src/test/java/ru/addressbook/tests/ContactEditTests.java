package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;
import ru.addressbook.model.Contacts;
import ru.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by xxmoised on 15.10.2016.
 */
public class ContactEditTests extends TestBase {


@Test
public void testEditingContact() {
    app.contact().ContactPage();
    Contacts before = app.contact().all();
    ContactData editedcontact = before.iterator().next();
    ContactData contact = new ContactData().withIdC(editedcontact.getIdC())
            .withFirstname("test2")
            .withLastname("123");
    app.contact().EditContact(editedcontact.getIdC(),contact);
    app.contact().ContactPage();
    Contacts after = app.contact().all();
    assertEquals(after.size(),before.size());


    before.remove(editedcontact);
    before.add(contact);
    assertThat(after, equalTo(
            before.without(editedcontact).withAdded(contact)));
    }


}
