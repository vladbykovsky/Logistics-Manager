package sample.Repositry;

import javafx.collections.ObservableList;
import sample.models.Trucker;

import java.sql.SQLException;

public interface TruckerRepository {

    ObservableList<Trucker> getAllTruckers() throws SQLException, ClassNotFoundException;
    void setTrucker(String name, String surname, int age, int experience, String city, double bank, String status)
            throws SQLException, ClassNotFoundException;

}
