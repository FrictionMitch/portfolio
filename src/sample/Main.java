package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/sample.fxml"));
//        primaryStage.getIcons().add(new Image("/pictures/nemo.png"));
        primaryStage.setTitle("Paps");
//        Image applicationIcon = new Image(getClass().getResourceAsStream("/pictures/nemo.ico"));
//        primaryStage.getIcons().add(applicationIcon);
        primaryStage.setScene(new Scene(root, 350, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
