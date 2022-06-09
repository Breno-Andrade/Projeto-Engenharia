package menus;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import dominio.Usuario;
import dao.UsuarioDAO;


public class UsuarioMenu {
    
    public static void cadastrarUsuario(){
        JOptionPane.showMessageDialog(null, "===== Cadastra Usuario =====");
        
        Usuario u = new Usuario();
        u.setNome(JOptionPane.showInputDialog("Digite o nome: "));
        u.setEmail(JOptionPane.showInputDialog("Digite o email: "));
        u.setSenha(JOptionPane.showInputDialog("Digite a senha: "));
        u.setNivel_permissao(JOptionPane.showInputDialog("Digite o nivel de permissão da conta: "));

        boolean reserva =  UsuarioDAO.cadastraUsuario(u);

        if(reserva) {
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!!");
        }else {
            JOptionPane.showMessageDialog(null, "Erro durante o processo de cadastramento!!!");
        }
    }

   public static void buscarUsuario(){
    
        ArrayList <Usuario> usuario = UsuarioDAO.buscarUsuario();
        for (Usuario u : usuario) {
            JOptionPane.showMessageDialog(null, "[" + u.getId() + "]" +"Nome: " + u.getNome() + "\nEmail: " + u.getEmail() + "\nSenha: " + u.getSenha() + "\nNivel de permissão: " + u.getNivel_permissao());
        }
    }
}


