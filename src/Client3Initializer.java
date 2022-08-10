import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Client3Initializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        AnchorPane root = FXMLLoader.load(this.getClass().getResource("Client3Form.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Client 3");

        primaryStage.centerOnScreen();
        primaryStage.setScene(scene);
        primaryStage.show();
    }




}
