package ru.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by xxmoised on 15.11.2016.
 */
public class ContactAdressTest extends TestBase {

        @BeforeMethod
        public void ensurePreconditions() {
            app.contact().ContactPage();
            if (app.contact().all().size() == 0) {
                app.contact().initCreationContact();
                app.contact().createContact(new ContactData()
                        .withFirstname("FirstName")
                        .withLastname("LastName")
                        .withMiddlename("MiddleName")
                        .withAddress("fgbfgbfg")
                        .withEmail1("tests@tests.ru")
                        .withGroup("test1"));
            }
        }

        @Test
        public void testContactAddress() {
            app.contact().ContactPage();
            ContactData contact = app.contact().all().iterator().next();
            ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
            assertThat(contact.getAddress(),equalTo((contactInfoFromEditForm.getAddress())));

        }
    }
