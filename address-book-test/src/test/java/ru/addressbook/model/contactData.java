package ru.addressbook.model;

public class contactData {
    private final String name;
    private final String middlename;
    private final String secondname;
    private final String nickname;
    private final String companyname;
    private final String address;
    private final String phone;
    private final String email;
    private String group;

    public contactData(String name, String middlename, String secondname, String nickname, String companyname, String address, String phone, String email, String group) {
        this.name = name;
        this.middlename = middlename;
        this.secondname = secondname;
        this.nickname = nickname;
        this.companyname = companyname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getSecondname() {
        return secondname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCompanyname() {
        return companyname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }
}
