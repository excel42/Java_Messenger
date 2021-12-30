package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.io.DataOutputStream;
import java.io.IOException;


public class Server_Connect {

	private ServerSocket SerSock;
	private Socket Socket;

	private int i = 1;

	public static Map<String, DataOutputStream> cmap = new ConcurrentHashMap<String, DataOutputStream>();

	public void connect_server() throws IOException {
		SerSock = new ServerSocket(10000);
		while (true) {
			System.out.println("Server is just opend and wating for client NO." + i);
		    Socket = SerSock.accept();
			System.out.println("Client NO." + i +" is connected! The conneceted client address is " + Socket.getInetAddress());
			i++;
			Read_Server rs = new Read_Server(Socket);
			rs.start(); // 쓰레드 동작시작
		}
		
	}
	

}
