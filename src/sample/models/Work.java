package sample.models;

public class Work {
    private int workId;
    private Trucker trucker;
    private Order order;
    private int truckerId;
    private int orderId;

    public Work(int workId, int truckerId, int orderId) {
        this.workId = workId;
        this.truckerId = truckerId;
        this.orderId = orderId;
    }

    public Work(int truckerId, int orderId){
        this.truckerId = truckerId;
        this.orderId = orderId;
    }

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public int getTruckerId() {
        return truckerId;
    }

    public void setTruckerId(int truckerId) {
        this.truckerId = truckerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Trucker getTrucker() {
        return trucker;
    }

    public void setTrucker(Trucker trucker) {
        this.trucker = trucker;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
