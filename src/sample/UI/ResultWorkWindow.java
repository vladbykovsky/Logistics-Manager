package sample.UI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Answer;


public class ResultWorkWindow {
    public static void display(String answer){
        Stage window = new Stage();



        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Result");
        window.setWidth(360);
        window.setHeight(240);
        Label labelInfo = new Label();
        Button button = new Button("Ок");
        button.setOnAction(event -> {
            window.close();
        });
        switch (answer) {
            case "good":
                labelInfo.setText("Водитель и заказчик договорились!");
                break;
            case "fail goods":
                labelInfo.setText("Грузоподьемность не соответствует!");
                break;
            case "fail":
                labelInfo.setText("Водитель и заказчик не договорились!");
                break;
        }
        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(labelInfo, button);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }
}
