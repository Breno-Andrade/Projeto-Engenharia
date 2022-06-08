package menus;

import javax.swing.JOptionPane;

public class MenuPrincipal {
    private String aux;
    private int opcao;
    
    public MenuPrincipal(int opcao) {
        this.opcao = opcao;
    }

    public void exibeMenu(){
        aux = JOptionPane.showInputDialog(null, "Menu principal \n -----------------------------------------------------\n 1 - Reservar quadra\n 2 - Gestão de quadras\n 3 - Gestão de usuários\n 4 - Estatísticas do clube\n 5 - Sair");  
        opcao = Integer.parseInt(aux);
        
    }

    public void verificaOpcao(){
        switch (opcao) {
            case 1:
                // Reserva menuReserva = new Reserva(); 
                // menuReserva.exibeMenu();
                // menuReserva.verificaOpcao();
                ReservaMenu.exibeMenu();
                ReservaMenu.verificaOpcao();
                break;
            case 2:
            QuadraMenu.exibeMenu(); 
            QuadraMenu.verificaOpcao();
            // Gestão de quadras 
                break;
            case 3: 
            // Gestão de usuários
                UsuarioMenu.verificaOpcao();
                break;
            case 4:
            // Estatísticas do clube
                break;
            case 5:
            JOptionPane.showMessageDialog(null,"Saindo...");
                break;
            default:
            JOptionPane.showMessageDialog(null, "Opção Invalida!");
        }
    }
}
