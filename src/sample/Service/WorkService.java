package sample.Service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.DataBase.DBHandler;
import sample.Repositry.WorkRepository;
import sample.models.Work;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkService implements WorkRepository {
    public ObservableList<Work> getAllWork() throws SQLException, ClassNotFoundException {
        ResultSet result = DBHandler.getDbConnection().getAllWork();
        final ObservableList<Work> data = FXCollections.observableArrayList();
        while (result.next()) {
            data.add(new Work(result.getInt(1),
                    result.getInt(2),
                    result.getInt(3)));
        }
        return data;
    }

    public ObservableList<Work> getWorkByOrderId(int orderId) throws SQLException, ClassNotFoundException {
        ResultSet result = DBHandler.getDbConnection().getWorkByOrderId(orderId);
        final ObservableList<Work> data = FXCollections.observableArrayList();
        while (result.next()) {
            data.add(new Work(
                    result.getInt(1),
                    result.getInt(2),
                    result.getInt(3)));
        }
        return data;
    }

    public void setWork(int truckerId, int orderId)
            throws SQLException, ClassNotFoundException {
        Work work = new Work(truckerId, orderId);
        DBHandler.getDbConnection().setWork(work);
    }

    public void deleteWork(int orderId)
            throws SQLException, ClassNotFoundException {
        DBHandler.getDbConnection().deleteWork(orderId);
    }


}
