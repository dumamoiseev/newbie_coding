package ru.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;
import ru.addressbook.model.Groups;

import java.util.Comparator;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;

/**
 * Created by xxmoised on 11.10.2016.
 */
public class GroupEditTests extends TestBase {

@BeforeMethod
public void enshurePreconditoin() {
    app.goTo().groupPage();
    if(! app.group().isThereGroup()) {
       app.group().createGroup(new GroupData().withName("test1"));
          }
}

    @Test
    public void testModificationGroup(){
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData editdedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(editdedGroup.getId()).withName("test2");
        app.group().editGroup(group);
        assertThat(app.group().getGroupCount(),equalTo(before.size()));
        Groups after = app.group().all();

        before.remove(editdedGroup);
        before.add(group);
        assertThat(after, equalTo(
                before.without(editdedGroup).withAdded(group)));
    }


}
