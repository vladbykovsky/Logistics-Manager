package sample.Service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.DataBase.DBHandler;
import sample.Repositry.OrderRepository;
import sample.models.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderService implements OrderRepository {
    public ObservableList<Order> getAllOrders() throws SQLException, ClassNotFoundException {
        ResultSet result = DBHandler.getDbConnection().getAllOrders();
        final ObservableList<Order> data = FXCollections.observableArrayList();
        while (result.next()) {
            data.add(new Order(result.getInt(1),
                    result.getInt(2),
                    result.getString(3),
                    result.getString(4),
                    result.getInt(5),
                    result.getInt(6),
                    result.getInt(7),
                    result.getString(8),
                    result.getString(9))
            );
        }
        return data;
    }
    public ObservableList<Order> getOrderById(int id) throws SQLException, ClassNotFoundException {
        ResultSet result = DBHandler.getDbConnection().getOrderById(id);
        final ObservableList<Order> data = FXCollections.observableArrayList();
        while (result.next()) {
            data.add(new Order(result.getInt(1),
                    result.getInt(2),
                    result.getString(3),
                    result.getString(4),
                    result.getInt(5),
                    result.getInt(6),
                    result.getInt(7),
                    result.getString(8),
                    result.getString(9))
            );
        }
        return data;
    }

    public ObservableList<Order> getOrdersByWork() throws SQLException, ClassNotFoundException{
        ResultSet result = DBHandler.getDbConnection().getOrdersByWork();
        final ObservableList<Order> data = FXCollections.observableArrayList();
        while (result.next()) {
            data.add(new Order(result.getInt(1),
                    result.getInt(2),
                    result.getString(3),
                    result.getString(4),
                    result.getInt(5),
                    result.getInt(6),
                    result.getInt(7),
                    result.getString(8),
                    result.getString(9))
            );
        }
        return data;
    }

    public void updateOrderStatus(int id, String stat) throws SQLException, ClassNotFoundException{
        DBHandler.getDbConnection().updateOrderStatus(id, stat);
    }

    public void updateOrderTime(int id, int time) throws SQLException, ClassNotFoundException{
        DBHandler.getDbConnection().updateOrderTime(id, time);
    }
}
