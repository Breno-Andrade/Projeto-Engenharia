import javax.swing.JOptionPane;
import reserva.MenuReserva;

public class MenuPrincipal {
    private String aux;
    private int opcao;
    
    MenuPrincipal(int opcao) {
        this.opcao = opcao;
        exibeMenu();
        verificaOpcao();
    }

    public void exibeMenu(){
        aux = JOptionPane.showInputDialog(null, "Menu principal \n -----------------------------------------------------\n 1 - Agendamento\n 2 - Gestão de quadras\n 3 - Gestão de usuários\n 4 - Estatísticas do clube\n 5 - Sair");  
        opcao = Integer.parseInt(aux);
        
    }

    public void verificaOpcao(){
        switch (opcao) {
            case 1:
                // Reserva menuReserva = new Reserva(); 
                // menuReserva.exibeMenu();
                // menuReserva.verificaOpcao();
                MenuReserva.exibeMenu();
                MenuReserva.verificaOpcao();
                break;
            case 2:
            // Gestão de quadras 
                break;
            case 3: 
            // Gestão de usuários
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
