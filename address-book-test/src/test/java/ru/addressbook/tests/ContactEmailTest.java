package ru.addressbook.tests;

/**
 * Created by xxmoised on 15.11.2016.
 */import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;


import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

    public class ContactEmailTest extends  TestBase {
        @BeforeMethod
        public void ensurePreconditions() {
            app.goTo().gotoHomePage();
            if (app.contact().all().size()==0){
                app.contact().initCreationContact();
                app.contact().createContact((new ContactData()
                        .withFirstname("FirstName")
                        .withLastname("LastName")
                        .withMiddlename("MiddleName")
                        .withAddress("fgbfgbfg")
                        .withEmail1("tests@tests.ru")
                        .withGroup("test1")));
            }
        }
        @Test
        public  void  testContactEmails(){
            app.goTo().gotoHomePage();
            ContactData contact = app.contact().all().iterator().next();
            ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
            assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
        }

        private Object mergeEmails(ContactData contact) {
            return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                    .stream().filter((s)->!s.equals(""))
                    .collect(Collectors.joining("\n"));
        }
    }

