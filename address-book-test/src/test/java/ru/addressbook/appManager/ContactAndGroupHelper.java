package ru.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.addressbook.model.contactData;
import ru.addressbook.model.dataGroup;

/**
 * Created by xxmoised on 07.10.2016.
 */
public class ContactAndGroupHelper extends HelperBase {

    public ContactAndGroupHelper(FirefoxDriver wd) {
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
        click(By.name("group_name"));
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
}
