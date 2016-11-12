package ru.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.addressbook.model.contactData;
import ru.addressbook.model.dataGroup;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.cssSelector;

/**
 * Created by xxmoised on 07.10.2016.
 */
public class ContactAndGroupHelper extends HelperBase {

    public ContactAndGroupHelper(WebDriver wd)
    {
        super(wd);
    }

    public void deleteSelectedGroup() {
        click(By.xpath("//div[@id='content']/form/input[5]"));
    }

    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void viewGroups() {
        click(By.linkText("group page"));
    }

    public void cinfirmCreation() {
        click(By.name("submit"));
    }

    public void fillFormGroup(dataGroup dataGroup) {
        type(By.name("group_name"), dataGroup.getParameter1());
        type(By.name("group_footer"), dataGroup.getParameter2());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void fillFormContact(contactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("company"), contactData.getCompanyname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getPhone());
        type(By.name("email"), contactData.getEmail());

        if (creation){  new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        }
        else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    public void submitCreationContact() {
        click(By.name("submit"));
    }

    public void initCreationContact() {
        click(By.linkText("add new"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void initDeleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void ContactPage() {
        click(By.linkText("home"));
    }

    public void goToGroupPage() {
        click(By.linkText("groups"));
    }

    public void confirmDeleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }


    public void acceptDeleteContact() {
        wd.switchTo().alert().accept();
    }

    public void pickToEditContact() {
        click(By.xpath("//tr[@class='odd']/td[8]/a/img"));
    }

    public void confirmEditingContact() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void createContact(contactData contact) {
       initCreationContact();
       fillFormContact(contact,true);
       submitCreationContact();
        //gotoHomePage();
            }

    public boolean isTherecontact() {
        return isElementPresent(By.name("Selected[]"));
    }

    public List<dataGroup> getGroupList() {
        List<dataGroup> groups =new ArrayList<dataGroup>();
        List<WebElement> elements = wd.findElements(cssSelector("span.group"));
        for (WebElement element : elements)  {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            dataGroup group = new dataGroup(id,name,null);
            groups.add(group);
        }
        return groups;
    }

    public List<contactData> getContactList() {
        List<contactData> contacts =new ArrayList<contactData>();
        List<WebElement> elements = wd.findElements(By.xpath("//tr[@name = 'entry']"));
        for (WebElement element : elements)  {
            List<WebElement> stroki = wd.findElements(By.xpath("//td"));
                int id = Integer.parseInt( stroki.get(0).findElement(By.tagName("input")).getAttribute("value"));
                String firstname = stroki.get(2).getText();
                String lastename =  stroki.get(1).getText();

            contactData contact = new contactData(id,firstname,null, lastename,null,null,null,null,null,null);
            contacts.add(contact);
        }
        return contacts;
    }
}
