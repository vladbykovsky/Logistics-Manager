package sample.Repositry;

import javafx.collections.ObservableList;
import sample.models.Work;

import java.sql.SQLException;

public interface WorkRepository {
    ObservableList<Work> getAllWork() throws SQLException, ClassNotFoundException;
}
