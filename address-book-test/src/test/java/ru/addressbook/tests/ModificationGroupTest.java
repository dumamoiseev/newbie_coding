package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.dataGroup;

/**
 * Created by xxmoised on 11.10.2016.
 */
public class ModificationGroupTest extends TestBase {


    @Test
    public void testModificationGroup(){

        app.getGroupsHelper().selectGroup();
        app.getGroupsHelper().initGroupModification();
        app.getGroupsHelper().fillFormGroup(new dataGroup("999", "privet!!!!"));
        app.getGroupsHelper().submitGroupModification();
        app.getGroupsHelper().viewGroups();
    }
}
