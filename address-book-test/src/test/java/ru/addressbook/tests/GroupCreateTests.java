package ru.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.addressbook.model.GroupData;
import ru.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreateTests extends TestBase {

    @Test
    public void greatt() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test1");
        app.group().createGroup(group);
        app.group().viewGroups();
        Groups after = app.group().all();
        assertThat(after.size(),equalTo(before.size() + 1));

        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) ->g.getId()).max().getAsInt()))));
    }
}
