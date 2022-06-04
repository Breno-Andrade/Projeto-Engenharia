import javax.swing.JOptionPane;

import dominio.Usuario;
import menus.MenuPrincipal;

public class App {
    public static void main(String[] args) throws Exception {
        Boolean verificacao = false;
        String usuario = JOptionPane.showInputDialog(null, "Insira o nome de usuário: ");
        String senha = JOptionPane.showInputDialog(null, "Insira a senha de usuário: ");

        Usuario testeLogin = new Usuario(usuario, senha);
        MenuPrincipal menu = new MenuPrincipal(0);
        
         if (testeLogin.verificaUsuario(verificacao) == true){
            JOptionPane.showMessageDialog(null, "Login concluído!");
            menu.exibeMenu();
            menu.verificaOpcao();
        } else{
            JOptionPane.showMessageDialog(null, "Falha no login");
        }
    }
}
