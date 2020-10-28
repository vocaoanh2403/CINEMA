package cinema;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnect {
	private String db_name;
	private String db_user;
	private String db_pass;
	public MyConnect()
	{
		db_name = "manager_ticket_cinema";
		db_user = "root";
		db_pass = "123456";
	}
	public MyConnect(String db_name, String db_user, String db_pass) {
		super();
		this.db_name = db_name;
		this.db_user = db_user;
		this.db_pass = db_pass;
	}
	
	public Connection getcn(){
		Connection cn = null;
		try {
			//Database url	
			String url = "jdbc:mysql://localhost:3306/"+db_name+"?";
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url,db_user,db_pass);
		}catch(Exception ex) {
			ex.getMessage();
		}
		return cn;
	}
}
