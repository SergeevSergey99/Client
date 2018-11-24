import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        final int SERVER_PORT = 3247;

//        String serverAddress = "169.254.90.202";
        try {
            System.out.println();
            InetAddress ipAddress = InetAddress.getLocalHost();

            System.out.println(ipAddress + ":" + SERVER_PORT);

            Socket socket = new Socket(ipAddress, SERVER_PORT);
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
            while (true) {
                line = keyboard.readLine();
                System.out.println("Sending to server...");

                dataOutputStream.writeUTF(line);
                dataOutputStream.flush();

                line = dataInputStream.readUTF();

                System.out.println("Server answer is:");
                System.out.println(line);
                System.out.println();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
