package sample.Service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.DataBase.DBHandler;
import sample.Repositry.CustomerRepository;
import sample.models.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerService implements CustomerRepository {
    public ObservableList<Customer> getAllCustomers() throws SQLException, ClassNotFoundException {
        ResultSet result = DBHandler.getDbConnection().getAllCustomers();
        final ObservableList<Customer> data = FXCollections.observableArrayList();
        while (result.next()) {
            data.add(new Customer(result.getInt(1),
                    result.getString(2),
                    result.getDouble(3)));
        }
        return data;
    }
}
