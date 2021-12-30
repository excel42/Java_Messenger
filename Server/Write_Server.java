package Server;

import java.io.IOException;
import java.util.Iterator;

import Server.Server_Connect;

public class Write_Server {

	public static void SendMsg(String msg) {
		Iterator<String> it = Server_Connect.cmap.keySet().iterator();
		String key = "";
		while (it.hasNext()) {
			key = it.next();
			try {
				Server_Connect.cmap.get(key).writeUTF(msg);
				

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
