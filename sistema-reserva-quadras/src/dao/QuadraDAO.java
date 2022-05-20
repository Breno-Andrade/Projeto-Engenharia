package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import reserva.Quadra;

public class QuadraDAO {
	private static final String  Insert_SQL = "INSERT INTO reservaquadra (nome, cpf, tipo_quadra, dia_mes, hora_inicio, hora_termino) values (?,?,?,?,?,?)";
	private static final String Select_SQL = "SELECT * FROM public.reservaquadra";
	private static final String Delete_SQL = "DELETE FROM public.reservaquadra WHERE id = ?";
	
	private static final String User_SQL = "postgres";
	private static final String Url_SQL = "jdbc:postgresql://localhost/reserva";
	private static final String Password_SQL = "017017";

	public static ArrayList<Quadra> buscarReservas(){
		
		ArrayList <Quadra> quadra = new ArrayList();
		
		try {
			
			Connection conexao = DriverManager.getConnection(Url_SQL, User_SQL, Password_SQL);
			
			PreparedStatement stmt = conexao.prepareStatement (Select_SQL);
			
			ResultSet rs =stmt.executeQuery();
		
			while (rs.next()) {
				int id = rs.getInt ("id");
			    String nome= rs.getString("nome");
			    String cpf = rs.getString("cpf");
			    String tipo_quadra = rs.getString("tipo_quadra");
			    String dia_mes  = rs.getString("dia_mes");
			    String hora_inicio = rs.getString("hora_inicio");
			    String hora_termino = rs.getString("hora_termino");
  
			    Quadra q = new Quadra();
			    q.setId(id);
			    q.setNome(nome);
			    q.setCpf(cpf);
			    q.setTipoQuadra(tipo_quadra);
			    q.setDia_mes(dia_mes);
			    q.setHora_inicio(hora_inicio);
			    q.setHora_termino(hora_termino);
			    
			    
			    quadra.add(q);
			    
			}
			}catch (SQLException e){
				
				e.printStackTrace();
			}
		return quadra;
		
		}

	public static boolean reservarQuadra(Quadra q){
		
		boolean sucesso = false;
        
		try {
			Connection conexao = DriverManager.getConnection(Url_SQL, User_SQL, Password_SQL);
            PreparedStatement stmt = conexao.prepareStatement (Insert_SQL);
            
            stmt.setString(1, q.getNome());
            stmt.setString(2, q.getCpf());
            stmt.setString(3, q.getTipoQuadra());
            stmt.setString(4, q.getDia_mes());
            stmt.setString(5, q.getHora_inicio());
            stmt.setString(6, q.getHora_termino());
            
            
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
            	sucesso = true;
        
            }
      }catch (SQLException e) {
            	e.printStackTrace();
            }
		return sucesso;
        }
	
	public static boolean deletarReserva (Quadra q) {
		boolean sucesso = false;

	    
	    try {
	        Connection conexao = DriverManager.getConnection(Url_SQL, User_SQL, Password_SQL);  
	        PreparedStatement stmt = conexao.prepareStatement(Delete_SQL);

	            stmt.setInt(1, q.getId());

	            int rowsAffected = stmt.executeUpdate();

	            if (rowsAffected > 0){
	            	sucesso = true; 
	            }        
		  } catch (SQLException e ){
			  e.printStackTrace();
	    }
	    return sucesso;
	}
}