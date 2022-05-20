package reserva;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.QuadraDAO;

public class Reserva {

    static String  nome;
    static String cpf;
    static String tipo_quadra;
    static String dia_mes;
    static String horainicio;
    static String horafim;
    static int op;
    static String aux;

    public Reserva(){
        exibeMenu();
        verificaOpcao();
    }

    public static void exibeMenu(){
        aux = JOptionPane.showInputDialog("Digite o digito da ação da desejada! \n[1] Reservar quadra \n [2] Deletar quadra \n [3] Consultar quadras reservadas \n [4] Sair");
        op = Integer.parseInt(aux);
    }

    public static void verificaOpcao(){
        switch (op) {
            case 1:
            {
                JOptionPane.showMessageDialog(null, "===== Reservar Quadra =====");
                
                nome        = JOptionPane.showInputDialog("Digite o nome: ");
                cpf         = JOptionPane.showInputDialog("Digite o cpf: ");
                tipo_quadra = JOptionPane.showInputDialog("Digite o tipo da quadra: ");
                dia_mes     = JOptionPane.showInputDialog("Digite o dia e mes (ex: 00/00): ");
                horainicio  = JOptionPane.showInputDialog("Digite a hora de inicio desejada: (funcionamento = 06:00 at  22:00) ");
                horafim     = JOptionPane.showInputDialog("Digite a hora de termino desejada: ");
                
                  Quadra q = new Quadra();
                  q.setNome(nome);
                  q.setCpf(cpf);	
                  q.setTipoQuadra(tipo_quadra);
                  q.setDia_mes(dia_mes);
                  q.setHora_inicio(horainicio);
                  q.setHora_termino(horafim);
                  
                 boolean reserva =  QuadraDAO.reservarQuadra(q);
                 
                 if(reserva) {
                     JOptionPane.showMessageDialog(null, "Reserva cadastrada com sucesso!!!");
                 }else {
                     JOptionPane.showMessageDialog(null, "Erro ao cadastrar reserva!!!");
                 }
            }break;
            
            case 2: 
            {
                JOptionPane.showMessageDialog(null, "===== Deletar Quadra =====");
                ArrayList<Quadra> quadras = QuadraDAO.buscarReservas();
                
                for (Quadra q : quadras) {
                    JOptionPane.showMessageDialog(null, "[" + q.getId() + "]" + q.getNome());
                }
                String string = JOptionPane.showInputDialog("Digite o ID da reserva que deseja remover: ");
                int id = Integer.parseInt(string);
                
                Quadra q = new Quadra();
                q.setId(id);
                
                boolean removido = QuadraDAO.deletarReserva(q);
                
                 if(removido) {
                     JOptionPane.showMessageDialog(null, "Removido com sucesso!!!");
                 }else {
                     JOptionPane.showMessageDialog(null, "Erro ao remover reserva!!!");
                 }
            }break;
            
            case 3:
            { 
                ArrayList <Quadra> quadra = QuadraDAO.buscarReservas();
                for (Quadra q : quadra) {
                    System.out.println("id: " + q.getId());
                    System.out.println("Nome: " + q.getNome());
                    System.out.println("Cpf: " + q.getCpf());
                    System.out.println("Tipo quadra: " + q.getTipoQuadra());
                    System.out.println("Dia mes: " + q.getDia_mes());
                    System.out.println("hora inicio: " + q.getHora_inicio());
                    System.out.println("hora termino: " + q.getHora_termino());
                    System.out.println("");
                }break;
            }
            case 4:
            {
                JOptionPane.showMessageDialog(null, "Saindo!!"); break;
            }
            default:
            {
                JOptionPane.showMessageDialog(null, "Ops você digitou algo errado. Saindo");
            }
        }
    }
}