package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TLSClient {

	private static final Logger logger = Logger.getLogger(TLSClient.class.getName());

	public static TLSClient instance;

	private TLSClient() {
		if (logger.isLoggable(Level.INFO)) {
			logger.info(String.format("create instance of %s", this.getClass().getName()));
		}
	}

	public static TLSClient getInstance() {
		if (null == instance) {
			instance = new TLSClient();
		}
		return instance;
	}

	public byte[] sendTLSMessage(String host, int port, byte[] message) throws IOException {
		Socket socket = new Socket(host, port);

		OutputStream out = socket.getOutputStream();

		out.write(message, 0, message.length);

		out.close();
		socket.close();

		return getResponse(host, port);
	}

	public byte[] getResponse(String host, int port) {
		try (Socket socket = new Socket(host, port)) {
			// TODO set config for this
			socket.setSoTimeout(1000); // Read timeout in milliseconds
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			StringBuilder stringBuilder = new StringBuilder();

			String line;
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
			}

			return stringBuilder.toString().getBytes();
		} catch (Exception e) {
			// TODO make a decision
			// e.printStackTrace();
		}
		return new byte[0];
	}
}