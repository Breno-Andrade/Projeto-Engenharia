import javax.swing.JOptionPane;

public class menu {
    protected String aux;
    protected int op; 

    protected menu (String aux, int op) {
        this.aux = JOptionPane.showInputDialog(null, "Menu principal \n ---------------------\n 1 - Agendamento\n 2 - Gestão de quadras\n 3 - Gestão de usuários\n 4 - Estatísticas do clube\n 5 - Sair");  
        this.op = Integer.parseInt(aux);
        }

    protected void verificaOpcaoMenu() {
        switch (op) {
            case 1:
            // Classe do boquinha (Agendamento)
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
