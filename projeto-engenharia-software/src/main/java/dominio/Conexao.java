package dominio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Conexao {
    static final String Url_SQL = "jdbc:postgresql://localhost:5432/reserva";
    static final String User_SQL = "postgres";
    static final String Password_SQL = "017017";
    static Connection connection;

    public static Connection getConnection() {
        try {
            return (connection = DriverManager.getConnection(Url_SQL, User_SQL, Password_SQL));
        } catch (final SQLException e) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            return null;
        }
    }

    public static Connection getOfConnection() {
        try {
            connection = DriverManager.getConnection(Url_SQL, User_SQL, Password_SQL);
            connection.close();
            return (connection);
        } catch (final SQLException e) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            return null;
        }
    }
}


