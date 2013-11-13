import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(9999);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("server start");
		while(true) {
			try {
				Socket cli = server.accept();
				BufferedReader reader = new BufferedReader(new InputStreamReader(cli.getInputStream()));
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(cli.getOutputStream()));
				String line = null;
				while((line = reader.readLine()) != null) {
					//writer.write(line + "\r\n");
					//writer.flush();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
