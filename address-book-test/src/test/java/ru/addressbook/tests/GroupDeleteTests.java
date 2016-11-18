package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;
import ru.addressbook.model.Groups;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeleteTests extends TestBase {

    @BeforeMethod
    public void enshurePreconditoin() {
      app.goTo().groupPage();
        if (app.db().groups().size() == 0){
          app.group().createGroup(new GroupData().withName("test1"));
           app.goTo().gotoHomePage();
        }
    }

    @Test
    public void delete() {
        app.goTo().groupPage();
        Groups before = app.db().groups();
        GroupData deletedGroup = before.iterator().next();
        app.group().deleteGroup(deletedGroup);
        assertThat(app.group().getGroupCount(),equalTo(before.size() - 1));
        Groups after = app.db().groups();



        before.remove(deletedGroup );
        assertThat(after, equalTo(
                before.without(deletedGroup)));
    }



}
