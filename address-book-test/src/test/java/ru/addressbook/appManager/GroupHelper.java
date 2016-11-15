package ru.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.addressbook.model.GroupData;
import ru.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.By.cssSelector;

/**
 * Created by xxmoised on 07.10.2016.
 */
public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd)
    {
        super(wd);
    }

    public void deleteSelectedGroup() {
        click(By.xpath("//div[@id='content']/form/input[5]"));
    }

    public void selectGroupById(int id ) {
        wd.findElement(By.cssSelector("input[value  ='" + id + "']")).click();
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

    public void fillFormGroup(GroupData dataGroup) {
        type(By.name("group_name"), dataGroup.getParameter1());
        type(By.name("group_footer"), dataGroup.getParameter2());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void editGroup( GroupData group) {
        selectGroupById(group.getId() );
        initGroupModification();
        fillFormGroup(group);
        submitGroupModification();
        groupcache = null;
        viewGroups();
    }

    public void createGroup(GroupData group) {
        initGroupCreation();
        fillFormGroup(group);
        cinfirmCreation();
        groupcache = null;
    }



    public void deleteGroup(GroupData group) {
        selectGroupById(group.getId() );
        deleteSelectedGroup();
        groupcache = null;
        viewGroups();
    }


    public boolean isThereGroup() {
        return isElementPresent(By.name("Selected[]"));
    }

    public List<GroupData> list() {
        List<GroupData> groups =new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(cssSelector("span.group"));
        for (WebElement element : elements)  {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData().withId(id).withName("name");
            groups.add(group);
        }
        return groups;
    }

    private Groups groupcache = null;

    public Groups all() {
        if (groupcache != null) {
            return new Groups(groupcache);
        }
        groupcache =new Groups();
        List<WebElement> elements = wd.findElements(cssSelector("span.group"));
        for (WebElement element : elements)  {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupcache.add(new GroupData().withId(id).withName(name));
        }
        return new Groups(groupcache)  ;
    }


    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
}
