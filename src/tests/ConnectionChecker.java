package tests;

import java.net.InetSocketAddress;
import java.net.Socket;

public class ConnectionChecker {
    public static boolean isConnectionAvailable(String host, int port) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 1000); // 1000 ms timeout
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        boolean result = ConnectionChecker.isConnectionAvailable("localhost", 999);
        System.out.println(result);
    }
}