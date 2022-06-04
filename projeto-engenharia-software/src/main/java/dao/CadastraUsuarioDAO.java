package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import CadastraUsuario.CadastraUsuario;
import conexao.Conexao;

public class CadastraUsuarioDAO {
    private static final String  Insert_SQL = "INSERT INTO usuario (nome, sobrenome, rg, cpf, usuario, senha) values (?,?,?,?,?,?)";
    
    public static boolean cadastraUsuario(CadastraUsuario u){
		boolean sucesso = false;
        
        try {
			Connection conexao = Conexao.getConnection();
            PreparedStatement stmt = conexao.prepareStatement (Insert_SQL);
            
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getSobrenome());
            stmt.setString(3, u.getRg());
            stmt.setString(4, u.getCpf());
            stmt.setString(5, u.getUsuario());
            stmt.setString(6, u.getSenha());
            
            
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
