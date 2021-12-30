package Client2;

import java.util.Scanner;

public class main_client {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("닉네임을 입력하세요 : ");
		String nick = sc.nextLine();
		sc.close();
		Client_GUI gui = new Client_GUI(nick);

	}

}
