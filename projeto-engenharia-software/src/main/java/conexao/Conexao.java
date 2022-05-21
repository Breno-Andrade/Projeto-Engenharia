package conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection conectar(){
        final String Url_SQL = "jdbc:postgresql://localhost:5432/reserva";
        final String User_SQL = "postgres";
	    final String Password_SQL = "admin";
      
        try {
            Connection conexao = DriverManager.getConnection(Url_SQL, User_SQL, Password_SQL); 
            return conexao;
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Connection desconectar() {
        final String Url_SQL = "jdbc:postgresql://localhost:5432/reserva";
        final String User_SQL = "postgres";
	    final String Password_SQL = "admin";

        try {
            Connection conexao = DriverManager.getConnection(Url_SQL, User_SQL, Password_SQL); 
            conexao.close();
            return conexao;
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return null;  
    }
}


