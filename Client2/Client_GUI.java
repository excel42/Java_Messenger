package Client2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client_GUI extends JFrame implements ActionListener {
	private JTextArea jta = new JTextArea(40, 25);
	private JTextField jtf = new JTextField(25);
	private JButton btnTransfer = new JButton("전송");
	private JScrollPane scrollPane;
	private static String nickName;
	private Client_connect c;

    Login login;
	public Client_GUI(String nickName) {
		this.nickName = nickName;
		JPanel panel = new JPanel();
		scrollPane = new JScrollPane(jta);
		jta.setEditable(false);
		login = new Login(this);
		c = new Client_connect();
		
        panel.add(scrollPane);
        add(scrollPane, BorderLayout.CENTER);
		panel.add(jtf, BorderLayout.SOUTH);
        panel.add(btnTransfer);
        add("South", panel);
		
		jtf.addActionListener(this);
        btnTransfer.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(false);
		setBounds(800, 100, 400, 600);
		setTitle(nickName+"채팅창");
		c.setGui(this);
		c.connect(nickName);
		
	}

	public void actionPerformed(ActionEvent e) {
		String msg ="[" + nickName + "]" + " : " + jtf.getText() + "\n";
		
		if(e.getSource()==btnTransfer){//전송버튼 눌렀을 경우
            c.SendMsg(msg);
            jtf.setText("");   
               if(jtf.getText().equals("")){  //메세지 입력없이 전송버튼만 눌렀을 경우
            	   return ;
               }                  
        }else{
        	c.SendMsg(msg);
    		jtf.setText(""); //일반 엔터키 눌렀을 경우 송신
        }
	}
	public void appendMsg(String msg) {
		jta.append(msg);
		jta.setCaretPosition(jta.getDocument().getLength());  // 맨아래로 스크롤한다.
	}

}
