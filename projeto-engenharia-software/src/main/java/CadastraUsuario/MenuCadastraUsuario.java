package CadastraUsuario;

import javax.swing.JOptionPane;

import dao.CadastraUsuarioDAO;


public class MenuCadastraUsuario {
    public static void verificaOpcao(){
        JOptionPane.showMessageDialog(null, "===== Cadastra Usuario =====");
        
        CadastraUsuario u = new CadastraUsuario();

        u.setNome(JOptionPane.showInputDialog("Digite o Nome: "));
        u.setEmail(JOptionPane.showInputDialog("Digite o Email: "));
        u.setSenha(JOptionPane.showInputDialog("Digite a Senha: "));
        u.setNivel_permissao(JOptionPane.showInputDialog("Digite o nivel de permissao: "));

        boolean reserva =  CadastraUsuarioDAO.cadastraUsuario(u);

        if(reserva) {
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!!");
        }else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar reserva!!!");
        }
    }
}

