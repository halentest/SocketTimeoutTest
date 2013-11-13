import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Main {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("connect...");
		Socket socket = new Socket("10.40.30.25", 9999);
		socket.setSoTimeout(0);
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line=in.readLine()) != null) {
			writer.write(line + "\r\n");
			writer.flush();
			System.out.println(reader.readLine());
		}
	}
}
