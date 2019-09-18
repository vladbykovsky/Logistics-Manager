package sample.models;

public class Customer {
    private int customerId;
    private String company;
    private double customerBank;

    public Customer(int customerId, String company, double customerBank) {
        this.customerId = customerId;
        this.company = company;
        this.customerBank = customerBank;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getCustomerBank() {
        return customerBank;
    }

    public void setCustomerBank(double customerBank) {
        this.customerBank = customerBank;
    }
}
