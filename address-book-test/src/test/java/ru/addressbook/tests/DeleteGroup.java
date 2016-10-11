package ru.addressbook.tests;

import org.testng.annotations.Test;

public class DeleteGroup extends TestBase {

    
    @Test
    public void delete() {

        app.getGroupsHelper().selectGroup();
        app.getGroupsHelper().deleteSelectedGroup();
        app.getGroupsHelper().viewGroups();
    }


}
