import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Proxy {

    public static double multiple(double v1, double v2) {
        double result = 0;
        try (Socket socket = new Socket("localhost", 5000);
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
             DataInputStream dis = new DataInputStream(socket.getInputStream())) {

            dos.writeDouble(v1);
            dos.writeDouble(v2);
            result = dis.readDouble();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
