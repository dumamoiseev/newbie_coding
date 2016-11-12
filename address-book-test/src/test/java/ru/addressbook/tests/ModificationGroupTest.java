package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.dataGroup;

import java.util.HashSet;
import java.util.List;

/**
 * Created by xxmoised on 11.10.2016.
 */
public class ModificationGroupTest extends TestBase {



    @Test
    public void testModificationGroup(){
        app.getGroupsHelper().goToGroupPage();
        List<dataGroup> before = app.getGroupsHelper().getGroupList();
        app.getGroupsHelper().selectGroup(before.size()-1);
        app.getGroupsHelper().initGroupModification();
        dataGroup group = new dataGroup(before.get(before.size()-1).getId(),"test3",null);
        app.getGroupsHelper().fillFormGroup(group);
        app.getGroupsHelper().submitGroupModification();
        app.getGroupsHelper().viewGroups();
        List<dataGroup> after = app.getGroupsHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size());

        before.remove(before.size()-1);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    }
}
