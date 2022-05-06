package reservadequadras;
import javax.swing.JOptionPane;

public class Cadastro {
    public static void main(String[] args) {
        while(true){
            String nome       = JOptionPane.showInputDialog("Digite seu nome: ");
            String cpf        = JOptionPane.showInputDialog("Digite seu cpf: ");
            String[] valores  = {"Saibro", "Tenis rápido","Beath tenis"};
            String seletor    = (String)JOptionPane.showInputDialog(null, "Escolha um tipo de quadra", "quadra", JOptionPane.QUESTION_MESSAGE, null, valores, valores[0]);
            String dia_mes    = JOptionPane.showInputDialog("Digite o dia e mês (ex: 00/00): ");
            String horainicio = JOptionPane.showInputDialog("Digite a hora de inicio desejada: (funcionamento = 06:00 até 22:00) ");
            String horafim    = JOptionPane.showInputDialog("Digite a hora de termino desejada: ");

            Reservas reserva = new Reservas(nome,cpf, dia_mes, seletor, horafim, horainicio);
            Reserva_Cadastro.adicionar(reserva);
            int escolha = JOptionPane.showConfirmDialog(null,"Deseja reservar mais uma quadra?");
            if (escolha == 1){
                break;
            }
        }
        System.out.println(Reserva_Cadastro.listar());
        int buscar = JOptionPane.showConfirmDialog(null, "Deseja buscar quadras?");
        if (buscar == 0) {
            String[] valores2 = {"Saibro", "Tenis rápido","Beath tenis"};
            String seletor2   = (String)JOptionPane.showInputDialog(null, "Escolha o tipo de quadra", "quadra", JOptionPane.QUESTION_MESSAGE, null, valores2, valores2[0]);
            Reserva_Cadastro quant = new Reserva_Cadastro();
            System.out.println("\nQuantidade de quadras encontradas: " + seletor2 + " = " + quant.buscar(seletor2));
        }
    }
}
