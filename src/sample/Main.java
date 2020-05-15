package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("User manager");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public static void primaryStageClose(){
        primaryStage.close();
    }
    public static void primaryStageShow(){ primaryStage.show();}
    public static void main(String[] args) {
        launch(args);
    }
}
