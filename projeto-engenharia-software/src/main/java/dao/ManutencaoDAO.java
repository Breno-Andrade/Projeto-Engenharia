package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dominio.Conexao;
import dominio.Manutencao;


// SEPARAR A CONEXÂO EM UMA CLASSE DIFERENTE
public class ManutencaoDAO {

	private static final String Insert_SQL = "INSERT INTO manutencaoquadra2 (numero, dia_inicio, dia_fim) values (?,?,?)";
	private static final String Select_SQL = "SELECT * FROM public.manutencaoquadra2";
	private static final String Delete_SQL = "DELETE FROM public.manutencaoquadra2 WHERE id = ?";
	private static final String Update_SQL = "UPDATE public.manutencaoquadra2 SET numero = ?, dia_inicio = ?, dia_fim = ?, WHERE id = ?";
											

	public static ArrayList<Manutencao> buscarManutencao(){
		
		ArrayList <Manutencao> manutencao = new ArrayList();
		
		try {	
			Connection conexao = Conexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement (Select_SQL);
			
			ResultSet rs =stmt.executeQuery();
		
			while (rs.next()) {
				int id = rs.getInt ("id");
				int numero = rs.getInt("numero");
			    String dia_inicio = rs.getString("dia_inicio");
			    String dia_fim = rs.getString("dia_fim");

			    Manutencao m = new Manutencao();

			    m.setId(id);
				m.setNumero(numero);
				m.setDia_inicio(dia_inicio);
			    m.setDia_fim(dia_fim);

			    manutencao.add(m); 
			}
		}catch (SQLException e){
				
			e.printStackTrace();
		}
		return manutencao;	
	}

	public static boolean adicionarManutencao(Manutencao m){
		boolean sucesso = false;
        
		try {
			Connection conexao = Conexao.getConnection();
            PreparedStatement stmt = conexao.prepareStatement (Insert_SQL);
            
			stmt.setInt(1, m.getNumero());
            stmt.setString(2, m.getDia_inicio());
            stmt.setString(3, m.getDia_fim());
            

            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
            	sucesso = true;
            }
			
      		}catch (SQLException e) {
            	e.printStackTrace();
            }
		return sucesso;
        }

		public static boolean deletarManutencao (Manutencao m) {
			boolean sucesso = false;
			
			try {
				Connection conexao = Conexao.getConnection(); 
				PreparedStatement stmt = conexao.prepareStatement(Delete_SQL);
	
					stmt.setInt(1, m.getId());
	
					int rowsAffected = stmt.executeUpdate();
	
					if (rowsAffected > 0){
						sucesso = true; 
					}        
			  } catch (SQLException e ){
				  e.printStackTrace();
			}
			return sucesso;
		}

	public static boolean atualizarManutencao(Manutencao m){
		boolean sucesso = false;
		
	try{
		Connection conexao = Conexao.getConnection(); 
	    PreparedStatement stmt = conexao.prepareStatement(Update_SQL);
		
		stmt.setInt(1, m.getNumero());
		stmt.setString(2, m.getDia_inicio());
		stmt.setString(3, m.getDia_fim());
		stmt.setInt(4, m.getId());
		
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


