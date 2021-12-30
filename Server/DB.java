package Server;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DB {
	Connection conn = null;
	String msg = null;
    static int count; 
	String sql;

	public Connection MakeConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/msg_db?allowPublicKeyRetrieval=true&useSSL=false";

			conn = DriverManager.getConnection(url, "root", "sql1234!");
			System.out.println("연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("class name error");

		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		}
		return conn;
	}
	
	public void saveLog(String log) {
		try {
			Connection conn = MakeConnection();
			Statement st = conn.createStatement();
			String s = "INSERT INTO msg_log (msg) VALUES ";
			s += "('" + log + "')";
			System.out.println(s);
			int i = st.executeUpdate(s);
			if (i == 1) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
			conn.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean saveID(String ID, String pass) {
		try {
			Connection conn = MakeConnection();
			String s = "INSERT INTO User_table(uid,password) VALUES(?,?)";
			PreparedStatement psmt = conn.prepareStatement(s);
			psmt.setString(1, ID);
			psmt.setString(2, pass);

			int result = psmt.executeUpdate();
			if (result == 1) {
				System.out.println("성공");
				return true;
			} else {
				System.out.println("실패");
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("finally")
	public String IDPASS(String ID) {
		String pw = new String();
		try {
			Connection conn = MakeConnection();
			String s = "SELECT password FROM user_table WHERE uid=?";
			PreparedStatement psmt = conn.prepareStatement(s);
			psmt.setString(1, ID);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				pw = rs.getString(1);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return pw;
		}
	}

}
