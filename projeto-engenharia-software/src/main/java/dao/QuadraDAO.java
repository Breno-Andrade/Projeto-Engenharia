package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cadastroquadra.Quadra;
import conexao.Conexao;

// SEPARAR A CONEXÂO EM UMA CLASSE DIFERENTE
public class QuadraDAO {
	private static final String Insert_SQL = "INSERT INTO testee (numero, tipo, coberta, arquibancada, banco_jogador) values (?,?,?,?,?)";
	private static final String Select_SQL = "SELECT * FROM public.testee";
	private static final String Delete_SQL = "DELETE FROM public.testee WHERE id = ?";
	private static final String Update_SQL = "UPDATE public.testee SET numero = ?, tipo = ?, coberta = ?, arquibancada = ?, banco_jogador = ? WHERE id = ?";

	public static ArrayList<Quadra> buscarQuadra(){
		
		ArrayList <Quadra> quadra = new ArrayList();
		
		try {
			
			Connection conexao = Conexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement (Select_SQL);
			
			ResultSet rs =stmt.executeQuery();
		
			while (rs.next()) {
				int id = rs.getInt ("id");
			    int numero= rs.getInt("numero");
			    String tipo = rs.getString("tipo");
			    String coberta = rs.getString("coberta");
			    String arquibancada  = rs.getString("arquibancada");
			    String banco = rs.getString("banco_jogador");
			    
			    Quadra q = new Quadra();

			    q.setId(id);
				q.setNumero(numero);
			    q.setTipo(tipo);
			    q.setCoberta(coberta);
			    q.setArquibancada(arquibancada);
			    q.setBanco(banco);
			    
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
	
	public static boolean deletarQuadra (Quadra q) {
		boolean sucesso = false;

	    try {
	        Connection conexao = Conexao.getConnection(); 
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

	public static boolean atualizarQuadra(Quadra q){
		boolean sucesso = false;
		
	try{
		Connection conexao = Conexao.getConnection(); 
	    PreparedStatement stmt = conexao.prepareStatement(Update_SQL);
		
		stmt.setInt(1, q.getNumero());
		stmt.setString(2, q.getTipo());
		stmt.setString(3, q.getCoberta());
		stmt.setString(4, q.getArquibancada());
		stmt.setString(5, q.getBanco());
		stmt.setInt(6, q.getId());
		
		int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
			sucesso = true; 
			}     
	} catch (SQLException e){
		e.printStackTrace();
	}
		return sucesso;
	}
}
