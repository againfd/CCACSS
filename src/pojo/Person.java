package pojo;

public class Person {
    private int id;
    private String name;
    private String sex;
    private int age;
    private String address;
    private String tele;
    private String picture;

    public Person(){}

    public Person(int id, String name, String sex, int age, String address, String tele, String picture) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.tele = tele;
        this.picture = picture;
    }

    public Person(String name, String sex, int age, String address, String tele, String picture) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.tele = tele;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", tele='" + tele + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
