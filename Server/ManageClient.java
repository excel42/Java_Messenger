package Server;

import java.io.DataOutputStream;
import Server.Server_Connect;

public class ManageClient {

	public static void addClient(String name, DataOutputStream out) {
		String msg = name + " is connected";
		System.out.println(msg);
		// gui 에 메시지 띄우기
		Server_Connect.cmap.put(name, out);
	}

	public static void removeClient(String name) {
		String msg = name + " is removed";
		System.out.println(msg);
		// gui 에 메시지 띄우기
		Server_Connect.cmap.remove(name);

	}
}
