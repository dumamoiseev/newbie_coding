package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.dataGroup;

import java.util.List;

public class DeleteGroup extends TestBase {

    
    @Test
    public void delete() {
        app.getGroupsHelper().goToGroupPage();
        List<dataGroup> before = app.getGroupsHelper().getGroupList();
        app.getGroupsHelper().selectGroup(before.size() -1);
        app.getGroupsHelper().deleteSelectedGroup();
        app.getGroupsHelper().viewGroups();
        List<dataGroup> after = app.getGroupsHelper().getGroupList();
        Assert.assertEquals(after.size()  ,before.size()-1);

        before.remove(before.size() -1);
        Assert.assertEquals(before, after);
    }

}
