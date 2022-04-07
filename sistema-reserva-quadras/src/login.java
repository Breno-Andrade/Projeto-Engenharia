import javax.swing.JOptionPane;

public class login {
    protected String usuario;
    protected String senha;
    protected boolean verificacao;
    
    protected login(String usuario, String aux, int senha) {
        this.usuario = JOptionPane.showInputDialog(null, "Insira o nome de usuário: ");

        //this.senha = JOptionPane.showInputDialog(null, "Insira a senha de usuário: ");
    }

    protected boolean verificaUsuario(boolean verificacao) {
        System.out.println(usuario);
        if (usuario == "admin") {
            JOptionPane.showMessageDialog(null, "Nome de usuário correto!");
            return true;
        } else {
            System.out.println(usuario);
            JOptionPane.showMessageDialog(null, "Nome de usuário incorreto!");
            return false;
        }
    }
}
