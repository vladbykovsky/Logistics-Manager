package sample.UI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Service.TruckerService;
import sample.models.Trucker;

import java.sql.SQLException;

public class AddTruckerWindow {
    public static void display() throws SQLException, ClassNotFoundException {

        TruckerService truckerService = new TruckerService();

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add");
        window.setWidth(480);
        window.setHeight(720);

        TextField textFieldName = new TextField();
        textFieldName.setMaxWidth(200);

        TextField textFieldSurName = new TextField();
        textFieldSurName.setMaxWidth(200);

        TextField textFieldAge = new TextField();
        textFieldAge.setMaxWidth(200);

        TextField textFieldExperience = new TextField();
        textFieldExperience.setMaxWidth(200);

        TextField textFieldCity = new TextField();
        textFieldCity.setMaxWidth(200);

        TextField textFieldBank = new TextField();
        textFieldBank.setMaxWidth(200);

        TextField textFieldStatus = new TextField();
        textFieldStatus.setMaxWidth(200);

        Button buttonAdd = new Button("Добавить");

        VBox vBox = new VBox(10);

        buttonAdd.setOnAction(event -> {
            if ((textFieldName.getText()).equals("")||
                    (textFieldSurName.getText()).equals("")||
                    (textFieldAge.getText()).equals("")||
                    (textFieldExperience.getText()).equals("")||
                    (textFieldCity.getText().equals(""))||
                    (textFieldBank.getText()).equals("")||
                    (textFieldStatus.getText()).equals("")){
                Label label = new Label("Неправильно введены данные!");
                label.setStyle("-fx-text-fill: red;");
                vBox.getChildren().add(label);
            }else{
                try {
                    truckerService.setTrucker(
                            textFieldName.getText(),
                            textFieldSurName.getText(),
                            Integer.parseInt(textFieldAge.getText()),
                            Integer.parseInt(textFieldExperience.getText()),
                            textFieldCity.getText(),
                            Double.parseDouble(textFieldBank.getText()),
                            textFieldStatus.getText()
                    );
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                window.close();
            }

        });


        vBox.getChildren().addAll(new Label("Имя"),textFieldName,
                new Label("Фамилия"),textFieldSurName,
                new Label("Возраст"),textFieldAge,
                new Label("Грузоподьемность"),textFieldExperience,
                new Label("Город"),textFieldCity,
                new Label("Счет"),textFieldBank,
                new Label("Статус"),textFieldStatus,
                buttonAdd);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }
}
