package ru.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.appManager.ContactHelper;
import ru.addressbook.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by xxmoised on 14.11.2016.
 */
public class ContactPhoneTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().gotoHomePage();
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
    public  void  testContactPhones(){
                app.goTo().gotoHomePage();
                ContactData contact = app.contact().all().iterator().next();
                ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
                assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
            }

            private Object mergePhones(ContactData contact) {
                return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                                .stream().filter((s)->!s.equals(""))
                                .map(ContactHelper::cleaned)
                                .collect(Collectors.joining("\n"));
           }

}
