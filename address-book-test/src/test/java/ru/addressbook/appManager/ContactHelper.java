package ru.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.addressbook.model.ContactData;
import ru.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xxmoised on 13.11.2016.
 */
public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd)
    {
        super(wd);
    }

    public void createContact(ContactData contact) {
        initCreationContact();
        fillFormContact(contact,true);
        submitCreationContact();
        //gotoHomePage();

    }
    public void fillFormContact(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("company"), contactData.getCompanyname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getPhone());
        type(By.name("email"), contactData.getEmail());

        if (creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        }
        else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    public void initCreationContact() {
        click(By.linkText("add new"));
    }

    public void submitCreationContact() {
        click(By.name("submit"));
    }

    public void initDeleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void selectContactById(int idC) {
        wd.findElement(By.xpath("//input[@value = '"+idC+"']")).click();;
    }

    public void ContactPage() {
        click(By.linkText("home"));
    }

    public void confirmDeleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void acceptDeleteContact() {
        wd.switchTo().alert().accept();
    }


    public void deleteContact(ContactData contact) {
        selectContactById(contact.getIdC());
        initDeleteContact();
        acceptDeleteContact();
    }


    public void EditContact(int idC, ContactData contact) {
        pickToEditContact(idC);
        fillFormContact(new ContactData()
                .withIdC(contact.getIdC())
                .withFirstname(contact.getFirstname())
                .withLastname(contact.getLastname()),false);
        confirmEditingContact();
    }

    public void pickToEditContact(int id) {
        wd.findElement(By.xpath("//a[@href ='edit.php?id="+id+"'] ")).click();


    }

    public void confirmEditingContact() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }


    public boolean isTherecontact() {
        return isElementPresent(By.name("Selected[]"));
    }
    public List<ContactData> getContactList() {
        List<ContactData> contacts =new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name = 'entry']"));
        for (WebElement element : elements)  {
            List<WebElement> stroki = wd.findElements(By.xpath("//td"));
            int id = Integer.parseInt( stroki.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String firstname = stroki.get(2).getText();
            String lastename =  stroki.get(1).getText();
            contacts.add(new ContactData().withIdC(id).withFirstname(firstname).withLastname(lastename));
        }
        return contacts;

    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        WebElement table = wd.findElement(By.id("maintable"));
        List<WebElement> allRows = table.findElements(By.xpath("//tr[@name = 'entry']"));
        for (WebElement row : allRows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id  = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData()
                    .withIdC(id)
                    .withLastname(cells.get(1).getText())
                    .withFirstname(cells.get(2).getText());
            contacts.add(contact);
        }
        return contacts;
    }

}
