package sample;

import sample.models.Order;
import sample.models.Trucker;

public class Answer {
    public String GenerateAnswer(Trucker trucker, Order order){

        if((trucker.getExperience() >= order.getRequirement())&&
                (trucker.getCity().equals(order.getCity()))){
            return "good";
        }

        if((trucker.getExperience() < order.getRequirement())){
            return "fail goods";
        }

        if((trucker.getExperience() >= order.getRequirement())&&
                (!trucker.getCity().equals(order.getCity()))){
            int a = (int) (Math.random()*5);
            if ((a == 1)||(a == 4)){
                return "fail";
            }else {
                return "good";
            }
        }

        return null;

    }
}
