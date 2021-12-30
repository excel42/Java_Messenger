package Server;

import java.io.*;
import java.net.Socket;


public class Read_Server extends Thread {
	private DataOutputStream out;
	private DataInputStream in;
	private String name;
    private DB db = new DB();
	public String msg;

	public Read_Server(Socket socket) throws IOException {
		out = new DataOutputStream(socket.getOutputStream());
		in = new DataInputStream(socket.getInputStream());
		name = in.readUTF();

		ManageClient.addClient(name, out);
	}

	public void run() {
		try {
			while (in != null) {
				msg = in.readUTF();
				Write_Server.SendMsg(msg);
				System.out.println(msg);
				db.saveLog(msg);
				msg = null;
			}
		} catch (IOException e) {
			ManageClient.removeClient(name);
		}
	}

}
