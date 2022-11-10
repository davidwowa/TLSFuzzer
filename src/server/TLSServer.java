package server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TLSServer {
	public void simpleServer() throws IOException {
		ServerSocket serverSocket = new ServerSocket(4444);

		Socket socket = serverSocket.accept();
		InputStream in = socket.getInputStream();
		OutputStream out = new FileOutputStream("server_input.data");

		byte[] bytes = new byte[10];

		in.read(bytes);
		out.write(bytes, 0, bytes.length - 1);

		out.close();
		in.close();
		socket.close();
		serverSocket.close();
	}
}