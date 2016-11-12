package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.dataGroup;

import java.util.HashSet;
import java.util.List;

public class GroupCreateTests extends TestBase {

    @Test
    public void greatt() {
        app.getGroupsHelper().goToGroupPage();
        List<dataGroup> before = app.getGroupsHelper().getGroupList();
        app.getGroupsHelper().initGroupCreation();
        dataGroup group = new dataGroup("test1",null);
        app.getGroupsHelper().fillFormGroup(group);
        app.getGroupsHelper().cinfirmCreation();
        app.getGroupsHelper().viewGroups();
        List<dataGroup> after = app.getGroupsHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size() + 1);

        before.add(group);
        int max = 0;
        for (dataGroup g : after) {
            if (g.getId() > max){
                max = g.getId();
            }
        }
        group.setId(max);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    }

}
