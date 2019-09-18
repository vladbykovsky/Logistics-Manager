package sample.models;

public class Trucker {
    private int truckerId;
    private String name;
    private String surName;
    private int age;
    private int experience;
    private String city;
    private double truckerBank;
    private String status;

    public Trucker(){}

    public Trucker(int truckerId, String name, String surName, int age, int experience, String city, double truckerBank, String status) {
        this.truckerId = truckerId;
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.experience = experience;
        this.city = city;
        this.truckerBank = truckerBank;
        this.status = status;
    }

    public Trucker(String name, String surName, int age, int experience, String city, double truckerBank, String status) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.experience = experience;
        this.city = city;
        this.truckerBank = truckerBank;
        this.status = status;
    }

    public int getTruckerId() {
        return truckerId;
    }

    public void setTruckerId(int truckerId) {
        this.truckerId = truckerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public double getTruckerBank() {
        return truckerBank;
    }

    public void setTruckerBank(double truckerBank) {
        this.truckerBank = truckerBank;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Trucker{" +
                "truckerId=" + truckerId +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", experience=" + experience +
                ", truckerBank=" + truckerBank +
                ", status='" + status + '\'' +
                '}';
    }
}
