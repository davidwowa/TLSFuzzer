package util;

import java.net.InetAddress;

public class PingUtil {

    public boolean sendEchoRequest(String ipAddress) {
        try {
            InetAddress address = InetAddress.getByName(ipAddress);
            System.out.println("Sending Echo Request to " + ipAddress);
            boolean reachable = address.isReachable(5000); // Timeout in milliseconds
            return reachable;
        } catch (Exception e) {
            System.err.println("Error sending Echo Request: " + e.getMessage());
            return false;
        }
    }
}