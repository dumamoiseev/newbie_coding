package ru.addressbook.model;

public class dataGroup {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            dataGroup group = (dataGroup) o;

            if (id != group.id) return false;
            return name != null ? name.equals(group.name) : group.name == null;

        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

    public void setId(int id) {
        this.id = id;
    }

    private   int id;
    private final String name;
    private final String header;

    public dataGroup(String parameter1, String parameter2) {
        this.id = 0;
        this.name = parameter1;
        this.header = parameter2;
    }
    public dataGroup(int id, String parameter1, String parameter2) {
        this.id = id;
        this.name = parameter1;
        this.header = parameter2;
    }


    public int getId() {
        return id;
    }

    @Override
    public String  toString() {
        return "dataGroup{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getParameter1() {
        return name;
    }

    public String getParameter2() {
        return header;
    }
}
