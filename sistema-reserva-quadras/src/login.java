import javax.swing.JOptionPane;

public class login {
    protected String usuario;
    protected String senha;
    protected boolean verificacao;

    protected login(String usuario, String aux, int senha) {
        this.usuario = JOptionPane.showInputDialog(null, "Insira o nome de usuário: ");
        this.senha = JOptionPane.showInputDialog(null, "Insira a senha de usuário: ");
    }

    protected boolean verificaUsuario(boolean verificacao) {

        if (usuario.contains("admin") && senha.contains("123")) {
            //JOptionPane.showMessageDialog(null, "Login concluído!");
            return true;
        } else {
            //JOptionPane.showMessageDialog(null, "Falha no login!");
            return false;
        }
    }
}
