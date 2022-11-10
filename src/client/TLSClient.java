package client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TLSClient {

	public static TLSClient instance;

	private TLSClient() {
	}

	public static TLSClient getInstance() {
		if (null == instance) {
			instance = new TLSClient();
		}
		return instance;
	}

	public void sendTLSMessage(String host, int port, byte[] message) throws IOException {
		Socket socket = new Socket(host, port);

		OutputStream out = socket.getOutputStream();

		out.write(message, 0, message.length);

		out.close();
		socket.close();
	}
}