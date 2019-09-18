package sample.Repositry;

import javafx.collections.ObservableList;
import sample.models.Customer;

import java.sql.SQLException;

public interface CustomerRepository {
    ObservableList<Customer> getAllCustomers() throws SQLException, ClassNotFoundException;
}
