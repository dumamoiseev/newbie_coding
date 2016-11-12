package ru.addressbook.model;

public class contactData {
    private int idC= Integer.MAX_VALUE;
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String companyname;
    private final String address;
    private final String phone;
    private final String email;
    private String group;

    public contactData(int IdC, String firstname, String middlename, String lastname, String nickname, String companyname, String address, String phone, String email, String group) {
        this.idC = IdC;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.companyname = companyname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        contactData that = (contactData) o;

        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    public contactData(String firstname, String middlename, String lastname, String nickname, String companyname, String address, String phone, String email, String group) {
        this.idC = 0;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.companyname = companyname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.group = group;
    }





    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCompanyname() {
        return companyname;
    }

    @Override
    public String toString() {
        return "contactData{" +
                "idC=" + idC +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
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

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public int getIdC() {
        return idC;
    }
}
