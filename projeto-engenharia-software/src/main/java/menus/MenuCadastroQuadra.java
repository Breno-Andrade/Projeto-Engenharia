package menus;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.QuadraDAO;
import dominio.Quadra;

public class MenuCadastroQuadra {
  static String tipo;
  static String coberta;
  static String arquibancada;
  static String banco_jogador;
  static int op;
  static String aux;
  static String status;

  public static void exibeMenu() {
    aux = JOptionPane.showInputDialog(
        "Digite o digito da ação da desejada!  \n-----------------------------------------------------\n 1 - Cadastrar \n 2 - Deletar \n 3 - Consultar  \n 4 - Atualizar  \n 5 - Desbloquear ou Bloquear \n 6 - Sair");
    op = Integer.parseInt(aux);
  }

  public static void verificaOpcao() {
    switch (op) {
      case 1: {
        JOptionPane.showMessageDialog(null, "===== Cadastro Quadra =====");

        String aux = JOptionPane.showInputDialog("Digite o Número: ");
        int numero = Integer.parseInt(aux);

        String[] valores = { "Saibro", "Tenis rápido", "Beath tenis" };
        tipo = (String) JOptionPane.showInputDialog(null, "Escolha um tipo de quadra", "quadra",
            JOptionPane.QUESTION_MESSAGE, null, valores, valores[0]);

        String[] valores2 = { "SIM", "NÃO", };
        coberta = (String) JOptionPane.showInputDialog(null, "Possui cobertura? ", "quadra",
            JOptionPane.QUESTION_MESSAGE, null, valores2, valores2[0]);

        String[] valores3 = { "SIM", "NÃO", };
        arquibancada = (String) JOptionPane.showInputDialog(null, "Possui arquibancada? ", "quadra",
            JOptionPane.QUESTION_MESSAGE, null, valores3, valores3[0]);

        String[] valores4 = { "SIM", "NÃO", };
        banco_jogador = (String) JOptionPane.showInputDialog(null, "Possui bancos para os jogadores? ", "quadra",
            JOptionPane.QUESTION_MESSAGE, null, valores4, valores4[0]);

        Quadra q = new Quadra();
        q.setNumero(numero);
        q.setTipo(tipo);
        q.setCoberta(coberta);
        q.setArquibancada(arquibancada);
        q.setBanco(banco_jogador);

        boolean reserva = QuadraDAO.reservarQuadra(q);

        if (reserva) {
          JOptionPane.showMessageDialog(null, "Quadra cadastrada com sucesso!!!");
        } else {
          JOptionPane.showMessageDialog(null, "Erro ao cadastrar quadra!!!");
        }
      }break;

      case 2: {
        JOptionPane.showMessageDialog(null, "===== Deletar Quadra =====");
        ArrayList<Quadra> quadras = QuadraDAO.buscarQuadra();

        for (Quadra q : quadras) {
          JOptionPane.showMessageDialog(null, "[" + q.getId() + "]" + q.getNumero());
        }
        String string = JOptionPane.showInputDialog("Digite o ID da reserva que deseja remover: ");
        int id = Integer.parseInt(string);

        Quadra q = new Quadra();
        q.setId(id);

        boolean removido = QuadraDAO.deletarQuadra(q);

        if (removido) {
          JOptionPane.showMessageDialog(null, "Quadra removida com sucesso!!!");
        } else {
          JOptionPane.showMessageDialog(null, "Erro ao remover quadra!!!");
        }
      }break;

      case 3:
        ArrayList<Quadra> quadra = QuadraDAO.buscarQuadra();
        for (Quadra q : quadra) {
          JOptionPane.showMessageDialog(null, "[" + q.getId() + "]" + "Numero: "
              + q.getNumero() + "\nTipo de quadra: " + q.getTipo() + "\nCoberta: " + q.getCoberta() +
              "\nArquibancada: " + q.getArquibancada() + "\nBanco para jogador: " + q.getBanco());
        }break;

      case 4: {
        JOptionPane.showMessageDialog(null, "===== Atualizar Quadra =====");
        ArrayList<Quadra> quadras = QuadraDAO.buscarQuadra();

        for (Quadra q : quadras){
          JOptionPane.showMessageDialog(null, "[" + q.getId() + "]" + q.getNumero());
        }

        String string = JOptionPane.showInputDialog("Digite o ID da quadra que deseja atualizar");
        int id = Integer.parseInt(string);
        
        Quadra q = new Quadra();
        q.setId(id);
        
        JOptionPane.showMessageDialog(null, "===== Informe as novas característica da quadra  =====");
        String aux = JOptionPane.showInputDialog("Digite o Número da quadra: ");
        int numero = Integer.parseInt(aux);

        String[] valores = { "Saibro", "Tenis rápido", "Beath tenis" };
        tipo = (String) JOptionPane.showInputDialog(null, "Escolha o novo tipo de quadra", "quadra",
            JOptionPane.QUESTION_MESSAGE, null, valores, valores[0]);

        String[] valores2 = { "SIM", "NÃO", };
        coberta = (String) JOptionPane.showInputDialog(null, "Possui cobertura? ", "quadra",
            JOptionPane.QUESTION_MESSAGE, null, valores2, valores2[0]);

        String[] valores3 = { "SIM", "NÃO", };
        arquibancada = (String) JOptionPane.showInputDialog(null, "Possui arquibancada? ", "quadra",
            JOptionPane.QUESTION_MESSAGE, null, valores3, valores3[0]);

        String[] valores4 = { "SIM", "NÃO", };
        banco_jogador = (String) JOptionPane.showInputDialog(null, "Possui bancos para os jogadores? ", "quadra",
            JOptionPane.QUESTION_MESSAGE, null, valores4, valores4[0]);
        
         q.setNumero(numero);
         q.setTipo(tipo);
         q.setCoberta(coberta);
         q.setArquibancada(arquibancada);
         q.setBanco(banco_jogador);

         boolean reserva = QuadraDAO.atualizarQuadra(q);

         if (reserva) {
           JOptionPane.showMessageDialog(null, "Quadra cadastrada com sucesso!!!");
         } else {
           JOptionPane.showMessageDialog(null, "Erro ao atualizar quadra!!!");
         }
      }break;

        case 5: {
          JOptionPane.showMessageDialog(null, "===== Desbloquear e bloquear quadra =====");
          ArrayList<Quadra> quadras = QuadraDAO.buscarQuadra();
  
          for (Quadra q : quadras){
            JOptionPane.showMessageDialog(null, "[" + q.getId() + "]" + q.getNumero());
          }
  
          String string = JOptionPane.showInputDialog("Digite o ID da quadra que deseja atualizar");
          int id = Integer.parseInt(string);
          
          Quadra q = new Quadra();
          q.setId(id);
          
          String[] valores4 = {"Desbloqueado", "Bloqueado", };
          status = (String) JOptionPane.showInputDialog(null, "Informe o status da quadra ", "status",
              JOptionPane.QUESTION_MESSAGE, null, valores4, valores4[0]);
          
           q.setStatus(status);
  
           boolean reserva = QuadraDAO.statusQuadra(q);
  
           if (reserva) {
             JOptionPane.showMessageDialog(null, "Status da quadra alterado com sucesso!!!");
           } else {
             JOptionPane.showMessageDialog(null, "Erro ao alterar status da quadra!!!");
           }
        }break;

      case 6: {
        JOptionPane.showMessageDialog(null, "Saindo!!");
        break;
      }
      default: {
        JOptionPane.showMessageDialog(null, "Ops você digitou algo errado. Saindo!!");
      }
    }
  }
}
