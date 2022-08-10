import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Client1FormController {

    public TextField Client1Msg;
    public TextArea Client1Screen;
    public TextField txtClient1Msg;
    public TextArea txtClient1Screen;
    final  int PORT = 9010;
    public TextField txtUserName;
    public AnchorPane root;
    public TextField txtUSerNAmeClient;
    public TextField txtClient1;
    public Label lbiClient;
    Socket socket;
    DataInputStream dataInputStream2;
    DataOutputStream dataOutputStream2;

    String Message = "";
 //   String reply = "";

    public void initialize(){

        new Thread(() -> {
            try {
                socket = new Socket("localhost",PORT);

                dataOutputStream2 = new DataOutputStream(socket.getOutputStream());
                dataInputStream2= new DataInputStream(socket.getInputStream());
                //msg eka ena eka
                while (!Message.equals("exit")){
                    Message = dataInputStream2.readUTF();
                  //  System.out.println(Message);
                    txtClient1Screen.appendText("\n"+Message);

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
    public void BtnClient1Send(ActionEvent actionEvent) throws IOException {
    sendmsg();
    txtClient1Msg.clear();
    }

    private void  sendmsg() throws IOException {
        dataOutputStream2.writeUTF(lbiClient.getText()+"  : "+txtClient1Msg.getText());
        dataOutputStream2.flush();
    }

    public void BtnClient1Sendenter(ActionEvent actionEvent) throws IOException {

        sendmsg();
        txtClient1Msg.clear();
    }


    public void btnonClient(ActionEvent actionEvent) {
        lbiClient.setText(txtUSerNAmeClient.getText());
        txtUSerNAmeClient.clear();
    }
}
