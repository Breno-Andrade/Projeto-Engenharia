package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import CadastraUsuario.CadastraUsuario;
import dominio.Conexao;

public class CadastraUsuarioDAO {
    private static final String  Insert_SQL = "INSERT INTO usuario (nome, email, senha, nivel_permissao) values (?,?,?,?)";
    
    public static boolean cadastraUsuario(CadastraUsuario u){
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
}
