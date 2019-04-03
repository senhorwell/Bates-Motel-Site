import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection getConnection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/bates", "root", "senha123");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
