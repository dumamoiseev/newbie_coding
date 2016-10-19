package ru.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.addressbook.model.contactData;
import ru.addressbook.model.dataGroup;

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

    public void selectGroup() {
        click(By.name("selected[]"));
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

    public void fillFormContact(contactData contactData) {
        type(By.name("firstname"), contactData.getName());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getSecondname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("company"), contactData.getCompanyname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getPhone());
        type(By.name("email"), contactData.getEmail());
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
}
