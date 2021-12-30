package Client2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client_connect { 
	
	public Socket socket;
	public DataInputStream in;
	public DataOutputStream out;
	public Client_GUI gui;
	private String msg;
	private String nickName;
	
	public void setGui(Client_GUI gui){
		this.gui = gui;
	}
	
	public void connect(String NickName) {
		try {
			//socket = new Socket("192.168.32.173",7777);
			socket = new Socket("127.0.0.1",10000);
			System.out.println("서버 연결완료.");
			
			out = new DataOutputStream(socket.getOutputStream());
			 in = new DataInputStream(socket.getInputStream());
			 out.writeUTF(NickName);
			 System.out.println("닉네임 전송 완료!");
			 
			 while(in!=null)
			 {
				ReadMsg();
			 }
			 
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void ReadMsg() {
		try {
		msg = in.readUTF();
		gui.appendMsg(msg);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void SendMsg(String msg) {
		try {
			out.writeUTF(msg);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	    
	   
}
