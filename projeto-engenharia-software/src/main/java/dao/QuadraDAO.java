package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cadastroquadra.Quadra;
import conexao.Conexao;

// SEPARAR A CONEXÂO EM UMA CLASSE DIFERENTE
public class QuadraDAO {
	private static final String Insert_SQL = "INSERT INTO quadracadastro (numero, tipo, coberta, arquibancada, banco) values (?,?,?,?,?)";
	//private static final String Select_SQL = "SELECT * FROM public.quadracadastro";
	//private static final String Delete_SQL = "DELETE FROM public.quadracadastro WHERE id = ?";	

	// public static ArrayList<Quadra> buscarReservas(){
		
	// 	ArrayList <Quadra> quadra = new ArrayList();
		
	// 	try {
			
	// 		Connection conexao = Conexao.getConnection();
	// 		PreparedStatement stmt = conexao.prepareStatement (Select_SQL);
			
	// 		ResultSet rs =stmt.executeQuery();
		
	// 		while (rs.next()) {
	// 			int id = rs.getInt ("id");
	// 		    String nome= rs.getString("nome");
	// 		    String cpf = rs.getString("cpf");
	// 		    String tipo_quadra = rs.getString("tipo_quadra");
	// 		    String dia_mes  = rs.getString("dia_mes");
	// 		    String hora_inicio = rs.getString("hora_inicio");
	// 		    String hora_termino = rs.getString("hora_termino");
  
	// 		    Quadra q = new Quadra();
	// 		    q.setId(id);
	// 		    q.setNome(nome);
	// 		    q.setCpf(cpf);
	// 		    q.setTipoQuadra(tipo_quadra);
	// 		    q.setDia_mes(dia_mes);
	// 		    q.setHora_inicio(hora_inicio);
	// 		    q.setHora_termino(hora_termino);
			    
			    
	// 		    quadra.add(q);
			    
	// 		}
	// 		}catch (SQLException e){
				
	// 			e.printStackTrace();
	// 		}
	// 	return quadra;
		
	// 	}

	public static boolean reservarQuadra(Quadra q){
		
		boolean sucesso = false;
        
		try {
			Connection conexao = Conexao.getConnection();
            PreparedStatement stmt = conexao.prepareStatement (Insert_SQL);
            
            stmt.setInt(1, q.getNumero());
            stmt.setString(2, q.getTipo());
            stmt.setString(3, q.getCoberta());
            stmt.setString(4, q.getArquibancada());
            stmt.setString(5, q.getBanco());
            
            
            
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
            	sucesso = true;
        
            }
			
      }catch (SQLException e) {
            	e.printStackTrace();
            }
		return sucesso;
        }
	
	// public static boolean deletarReserva (Quadra q) {
	// 	boolean sucesso = false;

	    
	//     try {
	//         Connection conexao = Conexao.getConnection(); 
	//         PreparedStatement stmt = conexao.prepareStatement(Delete_SQL);

	//             stmt.setInt(1, q.getId());

	//             int rowsAffected = stmt.executeUpdate();

	//             if (rowsAffected > 0){
	//             	sucesso = true; 
	//             }        
	// 	  } catch (SQLException e ){
	// 		  e.printStackTrace();
	//     }
	//     return sucesso;
	// }
}
