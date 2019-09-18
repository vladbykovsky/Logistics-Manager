package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.UI.LoginWindow;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        LoginWindow.display();
//        MainWindow.display();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
