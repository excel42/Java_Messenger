package Client2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

import Server.DB;

public class Login extends JFrame{
	//private static final long serialVersionUID = 5576475938231976210L;
	private JPanel loginPanel = new JPanel(new GridLayout(3, 2));
    private JLabel idLabel = new JLabel("아이디 ");
    private JLabel pwLabel = new JLabel("비밀번호 ");
    private JTextField idText = new JTextField();
    private JPasswordField pwText = new JPasswordField();
    private JButton loginBtn = new JButton("로그인");
    private JButton signupBtn = new JButton("회원가입");
   
	public Login(Client_GUI gui)  {
	   super("로그인");
	   this.setContentPane(loginPanel);
	   loginPanel.add(idLabel);
	   loginPanel.add(pwLabel);
	   loginPanel.add(idText);
	   loginPanel.add(pwText);
	   loginPanel.add(loginBtn);
	   loginPanel.add(signupBtn);		
	   idLabel.setHorizontalAlignment(NORMAL);
       pwLabel.setHorizontalAlignment(NORMAL);
       setSize(350,150);
       this.setLocationRelativeTo(null);
       this.setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       loginBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
			DB db =new DB();
			String pw1 = new String();
			String id = idText.getText().trim();
			String pw = pwText.getText().trim();
			
			pw1 = db.IDPASS(id);
			if(id.length() == 0||pw.length()==0)
			{
			    JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력해주세요","아이디 비밀번호 입력",JOptionPane.DEFAULT_OPTION);
			    return;
			}
			
			
			if(pw.equals(pw1))
			{
				JOptionPane.showMessageDialog(null, "로그인성공","로그인 성공2",JOptionPane.DEFAULT_OPTION);
				setVisible(false);
				gui.setVisible(true);
				
				return;
			}else
			{
				JOptionPane.showMessageDialog(null, "로그인 실패","로그인 실패", JOptionPane.DEFAULT_OPTION);
				return;
			}
			
			
			
		}
	});
       
       
       
       signupBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new SignUp();
			
			return;


			
			
		}
	});
	//ssssssssss
       
     
	}
}
	


    

