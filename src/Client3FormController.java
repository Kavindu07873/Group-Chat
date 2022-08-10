import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client3FormController {
    public TextField txtClient3Msg;
    public TextArea txtClient3Screen;

    final  int PORT = 9010;
    public TextField txtUserName;
    public AnchorPane root;
    public TextField txtUSerNAmeClient3;
    public Label lblClient3;
    Socket socket;
    DataInputStream dataInputStream3;
    DataOutputStream dataOutputStream3;

    String Message = "";
    public void initialize(){
        new Thread(() -> {
            try {
                socket = new Socket("localhost",PORT);

                dataOutputStream3 = new DataOutputStream(socket.getOutputStream());
                dataInputStream3= new DataInputStream(socket.getInputStream());
                //msg eka ena eka


                while (!Message.equals("exit")){
                    Message = dataInputStream3.readUTF();
                    //  System.out.println(Message);
                    txtClient3Screen.appendText("\n"+Message);


//                    reply = txtClient1Screen.getText();
//                    dataOutputStream.writeUTF(reply);
//                    dataOutputStream.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void sendMsg() throws IOException {
        dataOutputStream3.writeUTF(lblClient3.getText()+"  : "+txtClient3Msg.getText());
        dataOutputStream3.flush();

    }

    public void BtnClient3Send(ActionEvent actionEvent) throws IOException {
        sendMsg();
        txtClient3Msg.clear();
    }

    public void BtnClient3SendClick(ActionEvent actionEvent) throws IOException {
    sendMsg();
    txtClient3Msg.clear();
    }



    public void btnonClient3(ActionEvent actionEvent) {

        lblClient3.setText(txtUSerNAmeClient3.getText());
        txtUSerNAmeClient3.clear();

    }
}
