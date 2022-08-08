import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ServerInitializer extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
//    primaryStage.getScene(new Scene(FXMLLoader.load(this.getClass().getResource("ServerForm.fxml"))));
//    primaryStage.show();

        AnchorPane root = FXMLLoader.load(this.getClass().getResource("ServerForm.fxml"));
        Scene scene = new Scene(root);
        primaryStage.centerOnScreen();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
