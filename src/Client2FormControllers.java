import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client2FormControllers {
    public TextField txtClient2Msg;
    public TextArea txtClient2Screen;


    final  int PORT = 5000;
//    public TextField txtClient1Msg;
//    public TextArea txtClient1Screen;

    Socket socket;
    DataInputStream dataInputStream1;
    DataOutputStream dataOutputStream1;

    String Message = "";
    //   String reply = "";


    public void initialize(){

        new Thread(() -> {
            try {
                socket = new Socket("localhost",PORT);

                dataOutputStream1 = new DataOutputStream(socket.getOutputStream());
                dataInputStream1 = new DataInputStream(socket.getInputStream());

                while (!Message.equals("exit")){

                    //msg eka gannawa
                    Message = dataInputStream1.readUTF();
                    //  System.out.println(Message);
                    txtClient2Screen.appendText("\n"+Message);


//                    reply = txtClient1Screen.getText();
//                    dataOutputStream.writeUTF(reply);
//                    dataOutputStream.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
    public void BtnClient2Send(ActionEvent actionEvent) throws IOException {
//        dataOutputStream1.writeUTF("Client 2 : "+txtClient2Msg.getText());
//        dataOutputStream1.flush();
        Sendmsg();
    }

    private void Sendmsg() throws IOException {
        dataOutputStream1.writeUTF("Client 2 : "+txtClient2Msg.getText());
        dataOutputStream1.flush();
    }

    public void BtnClient2SendClick(ActionEvent actionEvent) throws IOException {
        Sendmsg();
    }
}
