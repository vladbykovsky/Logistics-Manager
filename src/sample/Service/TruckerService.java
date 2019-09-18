package sample.Service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.DataBase.DBHandler;
import sample.Repositry.TruckerRepository;
import sample.models.Trucker;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TruckerService implements TruckerRepository {

    public ObservableList<Trucker> getAllTruckers() throws SQLException, ClassNotFoundException {
        ResultSet result = DBHandler.getDbConnection().getAllTruckers();
        final ObservableList<Trucker> data = FXCollections.observableArrayList();
        while (result.next()) {
            data.add(new Trucker(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4),
                    result.getInt(5),
                    result.getString(6),
                    result.getDouble(7),
                    result.getString(8))
            );
        }
        return data;
    }

    public ObservableList<Trucker> getTruckerById(int id) throws SQLException, ClassNotFoundException {
        ResultSet result = DBHandler.getDbConnection().getTruckerById(id);
        final ObservableList<Trucker> data = FXCollections.observableArrayList();
        while (result.next()) {
            data.add(new Trucker(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4),
                    result.getInt(5),
                    result.getString(6),
                    result.getDouble(7),
                    result.getString(8))
            );
        }
        return data;
    }

    public void setTrucker(String name, String surname, int age, int experience, String city, double bank, String status)
           throws SQLException, ClassNotFoundException {

        Trucker trucker = new Trucker(name,surname,age,experience,city,bank,status);
        DBHandler.getDbConnection().setTrucker(trucker);
    }

    public ObservableList<Trucker> getAllTruckersByExperience(int exp) throws SQLException, ClassNotFoundException {
        ResultSet result = DBHandler.getDbConnection().getAllTruckersByExperience(exp);
        final ObservableList<Trucker> data = FXCollections.observableArrayList();
        while (result.next()) {
            data.add(new Trucker(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4),
                    result.getInt(5),
                    result.getString(6),
                    result.getDouble(7),
                    result.getString(8))
            );
        }
        return data;
    }

    public ObservableList<Trucker> getAllTruckersByStatus(String status) throws SQLException, ClassNotFoundException {
        ResultSet result = DBHandler.getDbConnection().getAllTruckersByStatus(status);
        final ObservableList<Trucker> data = FXCollections.observableArrayList();
        while (result.next()) {
            data.add(new Trucker(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4),
                    result.getInt(5),
                    result.getString(6),
                    result.getDouble(7),
                    result.getString(8))
            );
        }
        return data;
    }

    public ObservableList<Trucker> getSearchTruckers(int exp, String status) throws SQLException, ClassNotFoundException {
        ResultSet result = DBHandler.getDbConnection().getSearchTruckers(exp, status);
        final ObservableList<Trucker> data = FXCollections.observableArrayList();
        while (result.next()) {
            data.add(new Trucker(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getInt(4),
                    result.getInt(5),
                    result.getString(6),
                    result.getDouble(7),
                    result.getString(8)
            ));
        }
        return data;
    }

    public void updateTruckerStatus(int id, String stat) throws SQLException, ClassNotFoundException{
        DBHandler.getDbConnection().updateTruckerStatus(id, stat);
    }

}
