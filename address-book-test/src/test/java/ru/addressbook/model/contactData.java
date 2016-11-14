package ru.addressbook.model;

public class ContactData {
    private int idC= Integer.MAX_VALUE;
    private  String firstname;
    private  String middlename;
    private  String lastname;
    private  String nickname;
    private  String companyname;
    private  String address;
    private  String phone;
    private  String email;
    private String group;

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData withCompanyname(String companyname) {
        this.companyname = companyname
        ;return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }
    public ContactData withIdC(int idC)
    {
        this.idC = idC;
        return this;
    }
    
    

    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }
    
    
    public int getIdC() {
        return idC;
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

    @Override
    public String toString() {
        return "ContactData{" +
                "idC=" + idC +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }


    public void setIdC(int idC) {
        this.idC = idC;
    }
}
