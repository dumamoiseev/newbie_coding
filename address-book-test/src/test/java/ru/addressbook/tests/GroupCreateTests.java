package ru.addressbook.tests;

import org.testng.annotations.Test;
import ru.addressbook.model.dataGroup;

public class GroupCreateTests extends TestBase {

    @Test
    public void greatt() {
        app.getGroupsHelper().initGroupCreation();
        app.getGroupsHelper().fillFormGroup(new dataGroup("12312312313289080809", "privet rebbyayayayayayta!!!!"));
        app.getGroupsHelper().cinfirmCreation();
        app.getGroupsHelper().viewGroups();
    }

}
