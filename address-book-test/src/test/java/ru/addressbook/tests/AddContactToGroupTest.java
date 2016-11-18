package ru.addressbook.tests;
import org.hibernate.SessionFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;
import ru.addressbook.model.Contacts;
import ru.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * Created by xxmoised on 18.11.2016.
 */
public class AddContactToGroupTest extends TestBase {


    private SessionFactory sessionFactory;

    @BeforeMethod

    // создаем контакт без группы
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().gotoHomePage();
            app.group().createGroup(new GroupData().withName("test3"));
        }

    }
    @Test
    public void testGroupsAdd(){
        app.contact().ContactPage();
        Contacts contacts = app.contact().all();
        int id = contacts.stream().mapToInt(ContactData::getIdC).max().getAsInt();
        app.contact().selectContactById(id);
        int idGroup = app.contact().selectContactToGroup();
        app.contact().addContactToGroup();
        ContactData contactData = app.db().loadContactById(id);
        assertThat(idGroup, equalTo(contactData.getGroups().iterator().next().getId()));
    }
}
