package sample.DataBase;

import sample.models.Trucker;
import sample.models.Work;

import java.sql.*;

public class DBHandler extends Config {

    public Connection connection;
    private Statement statement;
    public static DBHandler dbHandler;

    private DBHandler() {
        try {
            Class.forName(dbDriver).newInstance();
            this.connection = (Connection) DriverManager.getConnection(dbUrl + dbName + dbTimeZone, dbUser, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized DBHandler getDbConnection() {
        if (dbHandler == null) {
            dbHandler = new DBHandler();
        }
        return dbHandler;
    }

    public ResultSet getAllTruckers() throws SQLException, ClassNotFoundException {
        String select = "SELECT * FROM trucking.truckers";
        PreparedStatement prSt = getDbConnection().connection.prepareStatement(select);
        ResultSet resultSet = prSt.executeQuery();
        return resultSet;
    }

    public ResultSet getTruckerById(int id) throws SQLException, ClassNotFoundException {
        String select = "SELECT * FROM trucking.truckers WHERE truckers_id=" + id;
        PreparedStatement prSt = getDbConnection().connection.prepareStatement(select);
        ResultSet resultSet = prSt.executeQuery();
        return resultSet;
    }

    public ResultSet getSearchTruckers(int exp, String stat) throws SQLException, ClassNotFoundException {
        String select = "SELECT * FROM trucking.truckers WHERE experience>=" + exp + " AND status='" + stat + "'";
        PreparedStatement prSt = getDbConnection().connection.prepareStatement(select);
        ResultSet resultSet = prSt.executeQuery();
        return resultSet;
    }

    public ResultSet getAllTruckersByExperience(int exp) throws SQLException, ClassNotFoundException {
        String select = "SELECT * FROM trucking.truckers WHERE experience>=" + exp;
        PreparedStatement prSt = getDbConnection().connection.prepareStatement(select);
        ResultSet resultSet = prSt.executeQuery();
        return resultSet;
    }

    public ResultSet getAllTruckersByStatus(String stat) throws SQLException, ClassNotFoundException {
        String select = "SELECT * FROM trucking.truckers WHERE status='" + stat + "'";
        PreparedStatement prSt = getDbConnection().connection.prepareStatement(select);
        ResultSet resultSet = prSt.executeQuery();
        return resultSet;
    }

    public void updateTruckerStatus(int id, String stat) throws SQLException, ClassNotFoundException {
        String select = "UPDATE trucking.truckers SET status = '" + stat + "' WHERE truckers_id = " + id;
        PreparedStatement prSt = getDbConnection().connection.prepareStatement(select);
        prSt.executeUpdate();
    }

    public ResultSet getAllOrders() throws SQLException, ClassNotFoundException {
        String select = "SELECT * FROM trucking.orders";
        PreparedStatement prSt = getDbConnection().connection.prepareStatement(select);
        ResultSet resSet = prSt.executeQuery();
        return resSet;
    }

    public ResultSet getOrdersByWork() throws SQLException, ClassNotFoundException {
        String select = "SELECT * FROM trucking.orders WHERE status = 'выполняется'";
        PreparedStatement prSt = getDbConnection().connection.prepareStatement(select);
        ResultSet resSet = prSt.executeQuery();
        return resSet;
    }

    public ResultSet getOrderById(int id) throws SQLException, ClassNotFoundException {
        String select = "SELECT * FROM trucking.orders WHERE orders_id=" + id;
        PreparedStatement prSt = getDbConnection().connection.prepareStatement(select);
        ResultSet resultSet = prSt.executeQuery();
        return resultSet;
    }

    public void updateOrderStatus(int id, String stat) throws SQLException, ClassNotFoundException {
        String select = "UPDATE trucking.orders SET status = '" + stat + "' WHERE orders_id = " + id;
        PreparedStatement prSt = getDbConnection().connection.prepareStatement(select);
        prSt.executeUpdate();
    }

    public void updateOrderTime(int id, int time) throws SQLException, ClassNotFoundException {
        String select = "UPDATE trucking.orders SET time = '" + time + "' WHERE orders_id = " + id;
        PreparedStatement prSt = getDbConnection().connection.prepareStatement(select);
        prSt.executeUpdate();
    }

    public ResultSet getAllCustomers() throws SQLException, ClassNotFoundException {
        String select = "SELECT * FROM trucking.customers";
        PreparedStatement prSt = getDbConnection().connection.prepareStatement(select);
        ResultSet resSet = prSt.executeQuery();
        return resSet;
    }

    public ResultSet getAllWork() throws SQLException, ClassNotFoundException {
        String select = "SELECT * FROM trucking.work";
        PreparedStatement prSt = getDbConnection().connection.prepareStatement(select);
        ResultSet resSet = prSt.executeQuery();
        return resSet;
    }

    public ResultSet getWorkByOrderId(int orderId) throws SQLException, ClassNotFoundException {
        String select = "SELECT * FROM trucking.work WHERE order_id="+orderId;
        PreparedStatement prSt = getDbConnection().connection.prepareStatement(select);
        ResultSet resSet = prSt.executeQuery();
        return resSet;
    }

    public void setTrucker(Trucker trucker) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO trucking.truckers (name, surname, age, experience, bank_accunt, status) " +
                "VALUES (?,?,?,?,?,?)";
        PreparedStatement prSt = getDbConnection().connection.prepareStatement(insert);
        prSt.setString(1, trucker.getName());
        prSt.setString(2, trucker.getSurName());
        prSt.setInt(3, trucker.getAge());
        prSt.setInt(4, trucker.getExperience());
        prSt.setDouble(5, trucker.getTruckerBank());
        prSt.setString(6, trucker.getStatus());
        prSt.executeUpdate();
    }

    public void setWork(Work work) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO trucking.work (trucker_id, order_id) " +
                "VALUES (?,?)";
        PreparedStatement prSt = getDbConnection().connection.prepareStatement(insert);
        prSt.setInt(1, work.getTruckerId());
        prSt.setInt(2, work.getOrderId());
        prSt.executeUpdate();
    }

    public void deleteWork(int id) throws SQLException, ClassNotFoundException {
        String insert = "DELETE FROM trucking.work WHERE order_id = "+id;
        PreparedStatement preparedStatement = getDbConnection().connection.prepareStatement(insert);
        preparedStatement.executeUpdate();
    }
}