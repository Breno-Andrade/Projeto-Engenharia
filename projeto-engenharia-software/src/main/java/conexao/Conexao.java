package conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Conexao {

    public static Connection conectar(){
        final String Url_SQL = "jdbc:postgresql://192.168.15.12:5432/reserva";
        final String User_SQL = "postgres";
	    final String Password_SQL = "017017";
      
        try {
            Connection conexao = DriverManager.getConnection(Url_SQL, User_SQL, Password_SQL); 
            return conexao;
        } catch (final SQLException e) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        return null;
    }

    public static Connection desconectar() {
        final String Url_SQL = "jdbc:postgresql://192.168.15.12:5432/reserva";
        final String User_SQL = "postgres";
        final String Password_SQL = "017017";
        try {
            Connection conexao = DriverManager.getConnection(Url_SQL, User_SQL, Password_SQL); 
            conexao.close();
            return conexao;
        } catch (final SQLException e) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        return null;  
    }
}


