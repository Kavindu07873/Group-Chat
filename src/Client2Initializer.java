import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Client2Initializer extends Application {

    public TextField txtUserName;
    public AnchorPane root;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        AnchorPane root = FXMLLoader.load(this.getClass().getResource("Client2Form.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Client2");

        primaryStage.centerOnScreen();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
