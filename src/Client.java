import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        int serverPort = 3247;

        String serverAddress = "127.0.0.1";
        try {
            InetAddress ipAddress = InetAddress.getByName(serverAddress);

            System.out.println(serverAddress + ":" + serverPort);

            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("Connecting...");

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String line;

            System.out.println("Type something");
            System.out.println();

            //noinspection InfiniteLoopStatement
            while (true){
                line = keyboard.readLine();
                System.out.println("Sending to server...");

                dataOutputStream.writeUTF(line);
                dataOutputStream.flush();

                line = dataInputStream.readUTF();

                System.out.println("Server answer is:" + line);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
