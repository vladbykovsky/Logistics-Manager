package sample.models;

public class Order {
    private int orderId;
    private int fee;
    private String point;
    private String goods;
    private int requirement;
    private int time;
    private int customerId;
    private String city;
    private String status;

    public Order(){}

    public Order(int orderId, int fee, String point, String goods, int requirement, int time, int customerId, String city,String status) {
        this.orderId = orderId;
        this.fee = fee;
        this.point = point;
        this.goods = goods;
        this.requirement = requirement;
        this.time = time;
        this.customerId = customerId;
        this.city = city;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public int getRequirement() {
        return requirement;
    }

    public void setRequirement(int requirement) {
        this.requirement = requirement;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomer(int customerId) {
        this.customerId = customerId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
