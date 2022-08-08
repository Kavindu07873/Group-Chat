import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Client1FormController {

    public TextField Client1Msg;
    public TextArea Client1Screen;
    final  int PORT = 5000;
    public TextField txtClient1Msg;
    public TextArea txtClient1Screen;

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


//                    reply = txtClient1Screen.getText();
//                    dataOutputStream.writeUTF(reply);
//                    dataOutputStream.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
    public void BtnClient1Send(ActionEvent actionEvent) throws IOException {

//        String getMsg = txtClient1Msg.getText();
        //msg eka yawanawa
    dataOutputStream2.writeUTF("Client 1 :"+txtClient1Msg.getText());
    dataOutputStream2.flush();
    }
}
