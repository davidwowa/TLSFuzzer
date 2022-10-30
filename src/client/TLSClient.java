package client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TLSClient {
	public void sendTLSMessage(String host, int port, byte[] message) throws UnknownHostException, IOException {
		Socket socket = new Socket(host, port);

		OutputStream out = socket.getOutputStream();

		out.write(message, 0, message.length);

		out.close();
		socket.close();
	}
}