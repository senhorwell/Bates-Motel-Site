
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



//DAO para acessar tabela Contato
public class UserDAO {
	
	public Connection connection;
	
	public UserDAO(){
		
		this.connection = new ConnectionFactory().getConnection();
		
	}
	
public void inserir(User contato){
		
		String sql = 
				"INSERT INTO users (name,password, email) VALUES (?,?,?)";
		
		//utilize sempre prepared statement pois ele � mais r�pido que statement -> consulta parametrizada
		try {
			PreparedStatement prstate = connection.prepareStatement(sql);
			
			prstate.setString(1, contato.getName());
			prstate.setString(2, contato.getPassword());
			prstate.setString(3, contato.getEmail());
			
			prstate.execute();
			
			prstate.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
		}
				
		
	}

public void reservar(String email,String date, String numberPeoples, String numberDays ){
	
	String sql = 
			"INSERT INTO reservas (email,date, numberPeoples, numberDays) VALUES (?,?,?,?)";
	
	//utilize sempre prepared statement pois ele � mais r�pido que statement -> consulta parametrizada
	try {
		PreparedStatement prstate = connection.prepareStatement(sql);
		
		prstate.setString(1, email);
		prstate.setString(2, date);
		prstate.setString(3, numberPeoples);
		prstate.setString(4, numberDays);
		
		prstate.execute();
		
		prstate.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	} finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
			
	
}
	
public List<User> buscarPorNome(String nome){
	
	String sql = 
			"SELECT * FROM CONTATO WHERE NOME LIKE UPPER(?)";
	
	List<User> contatos = new ArrayList<User>();
	
	//utilize sempre prepared statement pois ele � mais r�pido que statement -> consulta parametrizada
	try {
		PreparedStatement prstate = connection.prepareStatement(sql);
		
		prstate.setString(1, new String("%"+nome+"%").toUpperCase());
				
		ResultSet resultado = 
				prstate.executeQuery();
		
		while (resultado.next()){
			User contato = new User();
			contato.setId(resultado.getInt("ID"));
			contato.setName(resultado.getString("NAME"));
			contato.setEmail(resultado.getString("EMAIL"));				
			contatos.add(contato);
		}
		resultado.close();
		prstate.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	} finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	return contatos;
	
}
public List<Reserva> buscarReservas(){
	
	String sql = 
			"SELECT * FROM reservas";
	
	List<Reserva> reservas = new ArrayList<Reserva>();
	
	//utilize sempre prepared statement pois ele � mais r�pido que statement -> consulta parametrizada
	try {
		PreparedStatement prstate = connection.prepareStatement(sql);

		ResultSet resultado = 
				prstate.executeQuery();
		
		while (resultado.next()){
//			Reserva reserva = new Reserva();
//			reserva.setEmail(resultado.getString("email"));
//			reserva.setDate(resultado.getString("date"));
//			reserva.setNumberDays(resultado.getString("numberDays"));
//			reserva.setNumberPeoples(resultado.getString("numberPeoples"));				
//			reservas.add(reserva);

			System.out.println(resultado.getString("email"));
			System.out.println(resultado.getString("date"));
			System.out.println(resultado.getString("numberDays"));
			System.out.println(resultado.getString("numberPeoples"));
		}
		resultado.close();
		prstate.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	} finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	return reservas;
	
}

	
public User buscarPorId(int id){
		
		String sql = 
				"SELECT * FROM CONTATO WHERE ID = ?";
		
		//utilize sempre prepared statement pois ele � mais r�pido que statement -> consulta parametrizada
		
		User contato = new User();
		
		try {
			PreparedStatement prstate = connection.prepareStatement(sql);
			
			prstate.setLong(1, id);
					
			ResultSet resultado = 
					prstate.executeQuery();
			
			resultado.next();
			
			
			contato.setId(resultado.getInt("ID"));
			contato.setName(resultado.getString("NAME"));
			contato.setEmail(resultado.getString("EMAIL"));
			
			resultado.close();
			prstate.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
		}
		
		return contato;
		
	}
public User buscarPorEmail(String email){
	
	String sql = 
			"SELECT * FROM CONTATO WHERE EMAIL = ?";
	
	//utilize sempre prepared statement pois ele � mais r�pido que statement -> consulta parametrizada
	
	User contato = new User();
	
	try {
		PreparedStatement prstate = connection.prepareStatement(sql);
		
		prstate.setString(1,email);
		ResultSet resultado = 
				prstate.executeQuery();
		
		resultado.next();
		
		
		contato.setId(resultado.getInt("ID"));
		contato.setName(resultado.getString("NAME"));
		contato.setEmail(resultado.getString("EMAIL"));
		
		resultado.close();
		prstate.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		throw new RuntimeException(e);
	} finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	return contato;
	
}
}
