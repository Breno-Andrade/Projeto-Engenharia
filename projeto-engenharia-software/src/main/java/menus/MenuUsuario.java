package menus;

import javax.swing.JOptionPane;
import dominio.Usuario;
import dao.CadastraUsuarioDAO;


public class MenuUsuario {
   public static void verificaOpcao(){
        JOptionPane.showMessageDialog(null, "===== Cadastra Usuario =====");
        
        Usuario u = new Usuario();
        u.setNome(JOptionPane.showInputDialog("Digite o nome: "));
        u.setEmail(JOptionPane.showInputDialog("Digite o email: "));
        u.setSenha(JOptionPane.showInputDialog("Digite a senha: "));
        u.setNivel_permissao(JOptionPane.showInputDialog("Digite o nivel de permissão da conta: "));

        boolean reserva =  CadastraUsuarioDAO.cadastraUsuario(u);

        if(reserva) {
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!!");
        }else {
            JOptionPane.showMessageDialog(null, "Erro durante o processo de cadastramento!!!");
        }
    }
}

