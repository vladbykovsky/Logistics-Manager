package sample;

import sample.Service.OrderService;
import sample.Service.TruckerService;
import sample.Service.WorkService;
import sample.models.Order;
import sample.models.Work;

import java.sql.SQLException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerWork {

    private static class MyTimeTask extends TimerTask
    {
        WorkService workService = new WorkService();
        OrderService orderService = new OrderService();
        TruckerService truckerService = new TruckerService();
        public void run()
        {
            try {
                for(Order order : orderService.getOrdersByWork()){
                    if(order.getTime()!=0){
                        orderService.updateOrderTime(order.getOrderId(), order.getTime()-1);
                    }else if(order.getTime()==0){
                        orderService.updateOrderStatus(order.getOrderId(), "выполнен");
                        truckerService.updateTruckerStatus(workService.getWorkByOrderId(
                                order.getOrderId()).get(0).getTruckerId(), "готов");
                        workService.deleteWork(order.getOrderId());
                    }
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public TimerWork(){
        Date date = new Date();
        Timer timer = new Timer();
        timer.schedule(new MyTimeTask(), date, 5000);
    }

}
