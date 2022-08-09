import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFormController {
    public AnchorPane root;
    public TextField ServerMsg;
    public TextArea ServerScreen;

    final  int PORT = 5000;
    final  int PORT2 = 5010;

    public TextField txtServerMsg;
    public TextArea txtServerScreen;

 //  ServerSocket serverSocket;
   // Socket accept;
    DataInputStream dataInputStream;
    DataInputStream dataInputStream1;
    DataInputStream dataInputStream2;

    DataInputStream dataInputStream3;

    DataOutputStream dataOutputStream;
  DataOutputStream dataOutputStream1;
    DataOutputStream dataOutputStream2;
    DataOutputStream dataOutputStream3;


    BufferedReader bufferedReader;
    String Message = "";

   // String Reply = "";



    public void initialize(){

            new Thread(() -> {
                try {
            ServerSocket serverSocket = new ServerSocket(PORT);
          //  ServerSocket serverSocket = new ServerSocket(PORT2);

                    txtServerScreen.appendText("Server Started...");

               Socket localsocket = serverSocket.accept();
                Socket localsoket2 = serverSocket.accept();
                    Socket localsoket3 = serverSocket.accept();


                    txtServerScreen.appendText("\nClient1 Connected...");
                    txtServerScreen.appendText("\nClient2 Connected...");
                    txtServerScreen.appendText("\nClient3 Connected...");

                    //Client3
                    dataOutputStream3 = new DataOutputStream(localsoket3.getOutputStream());
                    dataInputStream3 = new DataInputStream(localsoket3.getInputStream());


                    //Client 2
              dataOutputStream2 = new DataOutputStream(localsoket2.getOutputStream());
                 dataInputStream2 = new DataInputStream(localsoket2.getInputStream());


                    //Client 1
                   dataOutputStream = new DataOutputStream(localsocket.getOutputStream());
                   dataInputStream = new DataInputStream(localsocket.getInputStream());


//
//                    dataOutputStream = new DataOutputStream(localsocket2.getOutputStream());
//                    dataInputStream = new DataInputStream(localsocket2.getInputStream());
                    while (!Message.equals("exit")){
///////////////////////////////////////////////////////////////////////////////////////

                        //msg eka awa Client1
                       Message = dataInputStream.readUTF();
                     txtServerScreen.appendText("\n"+Message);
//                        Reply = txtServerScreen.getText();
//                        dataOutputStream.writeUTF(Reply);
//                        dataOutputStream.flush()


                       // Message = bufferedReader.readLine();
                        //dataOutputStream.writeUTF(Message);
                //msg yana eka
                            //msg eka awa client 2
//                        Message = dataInputStream2.readUTF();
//                        txtServerScreen.appendText("\n"+Message);

                        //Client2 yawwa
                        //Client2 yawwa
                   dataOutputStream.writeUTF(Message);
                   dataOutputStream.flush();
                            //Client 1 yawwa
                        dataOutputStream2.writeUTF(Message);
                        dataOutputStream2.flush();
                        //Client 3 yawwa
                        dataOutputStream3.writeUTF(Message);
                        dataOutputStream3.flush();

////////////////////////////////////////////////////////////////////////////////////////////////

                        //Msg eka awa client2 gen
                        Message = dataInputStream2.readUTF();
                        txtServerScreen.appendText("\n"+Message);

                        //Client2 yawwa client 2 ge msg eka
                        dataOutputStream.writeUTF(Message);
                        dataOutputStream.flush();
                        //Client 1  yawwa client 2 ge msg eka
                        dataOutputStream2.writeUTF(Message);
                        dataOutputStream2.flush();
                        //Client 3 yawwa
                        dataOutputStream3.writeUTF(Message);
                        dataOutputStream3.flush();

////////////////////////////////////////////////////////////////////////////////////////

                        //Msg eka awa Client3 gen
                        Message = dataInputStream3.readUTF();
                        txtServerScreen.appendText("\n"+Message);

                        //Client 1 yawwa
                        dataOutputStream2.writeUTF(Message);
                        dataOutputStream2.flush();
                        //Client 2 yawwa
                        dataOutputStream.writeUTF(Message);
                        dataOutputStream.flush();
                        //Client 3 yawwa
                        dataOutputStream3.writeUTF(Message);
                        dataOutputStream3.flush();

///////////////////////////////////////////////////////////////////////////////////////////
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
    }
    public void btnServerSend(ActionEvent actionEvent) throws IOException {
        dataOutputStream.writeUTF(txtServerMsg.getText());
        dataOutputStream.flush();
    }
}
