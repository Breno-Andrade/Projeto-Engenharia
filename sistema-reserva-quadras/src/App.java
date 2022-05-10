import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        String usuario = JOptionPane.showInputDialog(null, "Insira o nome de usuário: ");
        String senha = JOptionPane.showInputDialog(null, "Insira a senha de usuário: ");

        Usuario testeLogin = new Usuario(usuario, senha);
    
        if (testeLogin.verificaUsuario(false) == true){
            JOptionPane.showMessageDialog(null, "Login concluído!");
        }

        
    }
}
