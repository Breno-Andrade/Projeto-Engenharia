package CadastraUsuario;

import javax.swing.JOptionPane;

import dao.CadastraUsuarioDAO;


public class MenuCadastraUsuario {
    private static String nome;
    private static String sobrenome;
    private static String rg;
    private static String cpf;
    private static String usuario;
    private static String senha;   


    public static void verificaOpcao(){
        JOptionPane.showMessageDialog(null, "===== Cadastra Usuario =====");
        
        nome         = JOptionPane.showInputDialog("Digite o Nome: ");
        sobrenome    = JOptionPane.showInputDialog("Digite o Sobrenome: ");
        rg           = JOptionPane.showInputDialog(null, "Digite o RG: "); 
        cpf          = JOptionPane.showInputDialog("Digite o CPF: ");
        usuario      = JOptionPane.showInputDialog("Digite o nome de Usuario: ");
        senha        = JOptionPane.showInputDialog("Digite o a senha de sua conta: ");
        
        CadastraUsuario u = new CadastraUsuario();
        u.setNome(nome);
        u.setSobrenome(sobrenome);
        u.setRg(rg);
        u.setCpf(cpf);
        u.setUsuario(usuario);
        u.setSenha(senha);

        boolean reserva =  CadastraUsuarioDAO.cadastraUsuario(u);

        if(reserva) {
            JOptionPane.showMessageDialog(null, "Reserva cadastrada com sucesso!!!");
        }else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar reserva!!!");
        }
    }
}

