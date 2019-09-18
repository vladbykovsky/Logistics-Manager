package sample.UI;

import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Answer;
import sample.DataBase.DBHandler;
import sample.Service.CustomerService;
import sample.Service.OrderService;
import sample.Service.TruckerService;
import sample.Service.WorkService;
import sample.TimerWork;
import sample.models.Customer;
import sample.models.Order;
import sample.models.Trucker;
import sample.models.Work;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainWindow {

    public static void display() throws SQLException, ClassNotFoundException {

        TimerWork timerWork = new TimerWork();
        //DBHandler dbHandler = new DBHandler();
        DBHandler.getDbConnection();

        TruckerService truckerService = new TruckerService();
        OrderService orderService = new OrderService();
        CustomerService customerService = new CustomerService();
        WorkService workService = new WorkService();

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Main");
        window.setWidth(1600);
        window.setHeight(1000);

        Label labelTruckers = new Label("Все водители");
        Label labelOrders = new Label("Заказы");
        Label labelWork = new Label("Работа");
        Label labelCustomers = new Label("Заказчики");

        Button buttonAddTruckers = new Button("Добавить");
        Button buttonDeleteTruckers = new Button("Удалить");
        Button buttonAddWork = new Button("Отправить");
        Button buttonUpdate = new Button("Обновить");

        TextField textFieldTruckerId = new TextField();
        textFieldTruckerId.setMaxWidth(200);
        TextField textFieldOrderId = new TextField();
        textFieldOrderId.setMaxWidth(200);

        TableColumn<Trucker,Integer> TruckerIdColumn = new TableColumn<>("Id");
        TruckerIdColumn.setMaxWidth(50);
        TruckerIdColumn.setCellValueFactory(new PropertyValueFactory("truckerId"));

        TableColumn<Trucker,String> nameColumn = new TableColumn<>("Имя");
        nameColumn.setMaxWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory("name"));

        TableColumn<Trucker,String> surNameColumn = new TableColumn<>("Фамилия");
        surNameColumn.setMaxWidth(100);
        surNameColumn.setCellValueFactory(new PropertyValueFactory("surName"));

        TableColumn<Trucker,Integer> ageColumn = new TableColumn<>("Возраст");
        ageColumn.setMaxWidth(100);
        ageColumn.setCellValueFactory(new PropertyValueFactory("age"));

        TableColumn<Trucker,Integer> expColumn = new TableColumn<>("Грузоподъемность");
        expColumn.setMaxWidth(100);
        expColumn.setCellValueFactory(new PropertyValueFactory("experience"));

        TableColumn<Trucker,String> cityColumn = new TableColumn<>("Город");
        cityColumn.setMaxWidth(100);
        cityColumn.setCellValueFactory(new PropertyValueFactory("city"));

        TableColumn<Trucker,String> statusColumn = new TableColumn<>("Статус");
        statusColumn.setMaxWidth(100);
        statusColumn.setCellValueFactory(new PropertyValueFactory("status"));

        TableView<Trucker> tableAllTruckers = new TableView<>();
        tableAllTruckers.setEditable(true);
        tableAllTruckers.setMaxWidth(500);
        tableAllTruckers.setMaxHeight(300);
        tableAllTruckers.setItems(truckerService.getAllTruckers());
        tableAllTruckers.getColumns().addAll(TruckerIdColumn, nameColumn, surNameColumn, ageColumn, expColumn, cityColumn, statusColumn);


        TableColumn<Order,Integer> orderIdColumn = new TableColumn<>("Id");
        orderIdColumn.setMaxWidth(50);
        orderIdColumn.setCellValueFactory(new PropertyValueFactory("orderId"));

        TableColumn<Order,Integer> custIdColumn = new TableColumn<>("custId");
        custIdColumn.setMaxWidth(50);
        custIdColumn.setCellValueFactory(new PropertyValueFactory("customerId"));

        TableColumn<Order,Integer> feeColumn = new TableColumn<>("Гонорар");
        feeColumn.setMaxWidth(100);
        feeColumn.setCellValueFactory(new PropertyValueFactory("fee"));

        TableColumn<Order,String> pointColumn = new TableColumn<>("Куда");
        pointColumn.setMaxWidth(100);
        pointColumn.setCellValueFactory(new PropertyValueFactory("point"));

        TableColumn<Order,String> orderCityColumn = new TableColumn<>("Откуда");
        orderCityColumn.setMaxWidth(100);
        orderCityColumn.setCellValueFactory(new PropertyValueFactory("city"));

        TableColumn<Order,String> goodsColumn = new TableColumn<>("Груз");
        goodsColumn.setMaxWidth(100);
        goodsColumn.setCellValueFactory(new PropertyValueFactory("goods"));

        TableColumn<Order,String> requirementColumn = new TableColumn<>("Вес");
        requirementColumn.setMaxWidth(100);
        requirementColumn.setCellValueFactory(new PropertyValueFactory("requirement"));

        TableColumn<Order,String> timeColumn = new TableColumn<>("Дни");
        timeColumn.setMaxWidth(100);
        timeColumn.setCellValueFactory(new PropertyValueFactory("time"));

        TableColumn<Order,String> orderStatusColumn = new TableColumn<>("Статус");
        orderStatusColumn.setMaxWidth(100);
        orderStatusColumn.setCellValueFactory(new PropertyValueFactory("status"));

        TableView<Order> tableOrders = new TableView<>();
        tableOrders.setEditable(true);
        tableOrders.setMaxWidth(600);
        tableOrders.setMaxHeight(300);
        tableOrders.setItems(orderService.getAllOrders());
        tableOrders.getColumns().addAll(orderIdColumn,
                custIdColumn,
                feeColumn,
                orderCityColumn,
                pointColumn,
                goodsColumn,
                requirementColumn,
                timeColumn,
                orderStatusColumn);


        TableColumn<Customer,Integer> customerIdColumn = new TableColumn<>("Id");
        customerIdColumn.setMaxWidth(50);
        customerIdColumn.setCellValueFactory(new PropertyValueFactory("customerId"));

        TableColumn<Customer,String> companyColumn = new TableColumn<>("Компания");
        companyColumn.setMaxWidth(100);
        companyColumn.setCellValueFactory(new PropertyValueFactory("company"));

        TableView<Customer> tableCustomers = new TableView<>();
        tableCustomers.setEditable(true);
        tableCustomers.setMaxWidth(150);
        tableCustomers.setMaxHeight(300);
        tableCustomers.setItems(customerService.getAllCustomers());
        tableCustomers.getColumns().addAll(customerIdColumn, companyColumn);



        TableColumn<Work,Integer> workIdColumn = new TableColumn<>("Id");
        workIdColumn.setMaxWidth(50);
        workIdColumn.setCellValueFactory(new PropertyValueFactory("workId"));

        TableColumn<Work,Integer> truckerWorkColumn = new TableColumn<>("Водитель");
        truckerWorkColumn.setMaxWidth(100);
        truckerWorkColumn.setCellValueFactory(new PropertyValueFactory("truckerId"));

        TableColumn<Work,Integer> orderWorkColumn = new TableColumn<>("Заказ");
        orderWorkColumn.setMaxWidth(100);
        orderWorkColumn.setCellValueFactory(new PropertyValueFactory("orderId"));

        TableView<Work> tableWork = new TableView<>();
        tableWork.setEditable(true);
        tableWork.setMaxWidth(300);
        tableWork.setMaxHeight(150);
        tableWork.setItems(workService.getAllWork());
        tableWork.getColumns().addAll(workIdColumn, truckerWorkColumn, orderWorkColumn);

        TextField textFieldExp = new TextField();
        textFieldExp.setMaxWidth(50);

        TextField textFieldStatus = new TextField();
        textFieldStatus.setMaxWidth(50);

        TextField textFieldName = new TextField();
        textFieldName.setMaxWidth(50);

        Button buttonSearch = new Button("Поиск");
        buttonSearch.setOnAction(event -> {
            if((!textFieldExp.getText().equals(""))&&(!textFieldStatus.getText().equals(""))){
                try {
                    tableAllTruckers.setItems(truckerService.getSearchTruckers(Integer.parseInt(textFieldExp.getText()),
                            textFieldStatus.getText()));
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }else if((textFieldExp.getText().equals(""))&&(!textFieldStatus.getText().equals(""))){
                try {
                    tableAllTruckers.setItems(truckerService.getAllTruckersByStatus(textFieldStatus.getText()));
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }else if ((!textFieldExp.getText().equals(""))&&(textFieldStatus.getText().equals(""))){
                try {
                    tableAllTruckers.setItems(truckerService.getAllTruckersByExperience(Integer.parseInt(textFieldExp.getText())));
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });


        HBox hBox1 = new HBox(10);
        hBox1.getChildren().addAll(buttonSearch, buttonAddTruckers, buttonDeleteTruckers);

        HBox hBox2 = new HBox(10);
        hBox2.getChildren().addAll(new Label("Груз.под"), textFieldExp, new Label("Статус"), textFieldStatus);

        VBox vBox1 = new VBox(10);
        vBox1.getChildren().addAll(labelTruckers, tableAllTruckers,hBox2, hBox1);

        VBox vBox2 = new VBox(10);
        vBox2.getChildren().addAll(labelOrders, tableOrders);

        VBox vBox3 = new VBox(10);
        vBox3.getChildren().addAll(labelCustomers, tableCustomers);

        HBox hBox = new HBox(20);
        hBox.getChildren().addAll(vBox1, vBox2, vBox3);
        hBox.setAlignment(Pos.CENTER);

        VBox vBox4 = new VBox(10);
        vBox4.getChildren().addAll(labelWork, tableWork,
                new Label("Id водителя"), textFieldTruckerId,
                new Label("Id заказа"), textFieldOrderId,
                buttonAddWork, buttonUpdate);
        vBox4.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(hBox, vBox4);

        buttonAddTruckers.setOnAction(event -> {
            try {
                AddTruckerWindow.display();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });


        buttonAddWork.setOnAction(event -> {
            Label label = new Label("Неправильные данные!");
            label.setStyle("-fx-text-fill: red;");
            if((textFieldTruckerId.getText().equals(""))||(textFieldOrderId.getText().equals(""))){
                vBox4.getChildren().add(label);
            }else {
                Trucker trucker = new Trucker();
                Order order = new Order();
                try {
                    trucker = truckerService.getTruckerById(Integer.parseInt(textFieldTruckerId.getText())).get(0);
                    order = orderService.getOrderById(Integer.parseInt(textFieldOrderId.getText())).get(0);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Answer answer = new Answer();
                String a = answer.GenerateAnswer(trucker, order);

                if(a.equals("good")){
                    try {
                        workService.setWork(Integer.parseInt(textFieldTruckerId.getText()),
                            Integer.parseInt(textFieldOrderId.getText()));
                        truckerService.updateTruckerStatus(trucker.getTruckerId(), "занят");
                        orderService.updateOrderStatus(order.getOrderId(), "выполняется");
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    ResultWorkWindow.display(a);
                }else{
                    ResultWorkWindow.display(a);
                }
            }
        });

        buttonUpdate.setOnAction(event -> {
            try {
                tableAllTruckers.setItems(truckerService.getAllTruckers());
                tableOrders.setItems(orderService.getAllOrders());
                tableWork.setItems(workService.getAllWork());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        Scene scene= new Scene(vBox);
        window.setScene(scene);
        window.show();
    }


}
