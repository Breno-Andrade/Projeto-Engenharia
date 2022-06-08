package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dominio.Conexao;
import dominio.Usuario;

public class UsuarioDAO {
    private static final String Insert_SQL = "INSERT INTO reserva (nome, email, senha, nivel_permissao) values (?,?,?,?)";
    private static final String Select_SQL = "SELECT * FROM public.reserva";
    
    public static boolean cadastraUsuario(Usuario u){
		boolean sucesso = false;
        
        try {
			Connection conexao = Conexao.getConnection();
            PreparedStatement stmt = conexao.prepareStatement (Insert_SQL);
            
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getNivel_permissao());            
            
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
            	sucesso = true;
            }
			conexao = Conexao.getOfConnection();
        }catch (SQLException e) {
            	e.printStackTrace();
            }
		return sucesso;
        }

	public static ArrayList<Usuario> buscarUsuario(){
		
		ArrayList <Usuario> usuario = new ArrayList();
		
		try {
			Connection conexao = Conexao.getConnection();
			PreparedStatement stmt = conexao.prepareStatement (Select_SQL);
			
			ResultSet rs =stmt.executeQuery();
		
			while (rs.next()) {
				Usuario u = new Usuario();
                
                u.setId(rs.getInt("id"));
			    u.setNome(rs.getString("nome"));
			    u.setEmail(rs.getString("email"));
                u.setSenha(rs.getString("senha"));
                u.setNivel_permissao(rs.getString("nivel_permissao"));
                			    
			    usuario.add(u); 
			}
			}catch (SQLException e){
				e.printStackTrace();
			}
		return usuario;	
	}
}
