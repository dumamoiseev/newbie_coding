package ru.addressbook.model;

public class dataGroup {
    private final String parameter1;
    private final String parameter2;

    public dataGroup(String parameter1, String parameter2) {
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
    }

    public String getParameter1() {
        return parameter1;
    }

    public String getParameter2() {
        return parameter2;
    }
}
