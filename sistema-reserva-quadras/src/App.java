import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        login testeLogin = new login(null, null, 0);
    
        if (testeLogin.verificaUsuario(false) == true){
            JOptionPane.showMessageDialog(null, "Login concluído!");
        }
    }
}
