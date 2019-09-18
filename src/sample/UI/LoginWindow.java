package sample.UI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.SQLException;

public class LoginWindow {
    public static void display(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Login");
        window.setWidth(360);
        window.setHeight(240);

        Label labelTitle = new Label("Вход");
        Label labelLogin = new Label("Логин");
        Label labelPassword = new Label("Пароль");
        TextField textFieldLogin = new TextField();
        TextField textFieldPassword = new TextField();
        Button buttonLogin = new Button("Войти");
        HBox hBox1 = new HBox(10);
        HBox hBox2 = new HBox(10);
        VBox vBox = new VBox(10);

        buttonLogin.setOnAction(event -> {
            if((textFieldLogin.getText().equals("Vlad")&&(textFieldPassword.getText()).equals("1234"))){
                try {
                    MainWindow.display();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                window.close();
            }else {
                Label label = new Label("Неправильный логин или пароль!");
                label.setStyle("-fx-text-fill: red;");
                vBox.getChildren().add(label);
            }
        });

        hBox1.getChildren().addAll(labelLogin, textFieldLogin);
        hBox2.getChildren().addAll(labelPassword, textFieldPassword);
        vBox.getChildren().addAll(labelTitle,hBox1,hBox2, buttonLogin);
        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }
}
