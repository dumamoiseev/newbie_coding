package ru.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.addressbook.model.ContactData;
import ru.addressbook.model.Contacts;
import ru.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreateTests extends TestBase {


    @DataProvider
    public Iterator<Object[]>validContacts() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
        String xml = "";
        String line = reader.readLine();
        while (line != null){
            xml  = line;
            line = reader.readLine();
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
        return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();

    }

    @Test (dataProvider = "validContacts")
    public void createContact(ContactData contact) {
        app.contact().ContactPage();
        Contacts before = app.db().contacts();
        app.contact().initCreationContact();

         app.contact().fillFormContact(contact,true);
        app.contact().submitCreationContact();
        app.goTo().gotoHomePage();
        Assert.assertEquals(app.contact().count(), before.size()+1);
        Contacts after = app.db().contacts();

        assertThat(after, equalTo(
                before.withAdded(contact.withIdC(after.stream().mapToInt((g) -> g.getIdC()).max().getAsInt()))));
    }


}
