package sample.Repositry;

import javafx.collections.ObservableList;
import sample.models.Order;

import java.sql.SQLException;

public interface OrderRepository {

    ObservableList<Order> getAllOrders() throws SQLException, ClassNotFoundException;

}
