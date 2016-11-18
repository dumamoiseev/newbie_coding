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

    private Contacts  contactCache = null;

    public void createContact(ContactData contact) {
        initCreationContact();
        fillFormContact(contact,true);
        submitCreationContact();
        contactCache = null;


    }
    public void fillFormContact(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("email"), contactData.getEmail());

        if (creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
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
        contactCache = null;
        acceptDeleteContact();

    }


    public void EditContact(int idC, ContactData contact) {
        pickToEditContact(idC);
        fillFormContact(new ContactData()
                .withIdC(contact.getIdC())
                .withFirstName(contact.getFirstName())
                .withLastName(contact.getLastName()),false);
        confirmEditingContact();
        contactCache = null;
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


    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        Contacts contactCache = new Contacts();
        Contacts contacts = new Contacts();
        WebElement table = wd.findElement(By.id("maintable"));
        List<WebElement> allRows = table.findElements(By.xpath("//tr[@name = 'entry']"));
        for (WebElement row : allRows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id  = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData()
                    .withIdC(id)
                    .withLastName(cells.get(1).getText())
                    .withFirstName(cells.get(2).getText())
                    .withAddress(cells.get(3).getText())
                    .withAllEmails(cells.get(4).getText())
                    .withAllPhones(cells.get(5).getText());
            contactCache.add(contact);
        }
        return new Contacts(contactCache);
    }

    public int count() {
        return wd.findElements(By.xpath("//tr[@name = 'entry']")).size();
    }

        public ContactData infoFromEditForm(ContactData contact) {
                pickToEditContact(contact.getIdC());
                String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
                String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
                String middlename = wd.findElement(By.name("middlename")).getAttribute("value");
                String address = wd.findElement(By.name("address")).getText();
                String email = wd.findElement(By.name("email")).getAttribute("value");
                String email2 = wd.findElement(By.name("email2")).getAttribute("value");
                String email3 = wd.findElement(By.name("email3")).getAttribute("value");
                String home = wd.findElement(By.name("home")).getAttribute("value");
                String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
                String work = wd.findElement(By.name("work")).getAttribute("value");
                wd.navigate().back();
                return new ContactData()
                                .withIdC(contact.getIdC())
                                .withFirstName(firstname)
                                .withLastName(lastname)
                                .withMiddleName(middlename)
                                .withAddress(address)
                                .withEmail(email)
                                .withEmail2(email2)
                                .withEmail3(email3)
                                .withHomePhone(home)
                                .withMobilePhone(mobile)
                                .withWorkPhone(work);
            }
    public static String cleaned(String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]","");
    }



    public void viewAllContactInfoById(int id) {
            wd.findElement(By.cssSelector("a[href='view.php?id=" + id + "']")).click();
          }

    public int selectContactToGroup() {
                WebElement group = wd.findElements(By.xpath("//select[@name = 'to_group']/option")).iterator().next();
                group.click();
                return  Integer.parseInt(group.getAttribute("value"));
            }


    public void selectGroup(int id) {
                wd.findElement(By.xpath("//select[@name = 'group']/option[@value ='"+id+"']")).click();
            }

            public void addContactToGroup() {
                wd.findElement(By.xpath("//input[@name = 'add']")).click();
           }
    public void removeFromGroup() {
               wd.findElement(By.xpath("//input[@name = 'remove']")).click();
           }
    }