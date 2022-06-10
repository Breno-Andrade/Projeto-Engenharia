package menus;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.ManutencaoDAO;
import dao.QuadraDAO;
import dominio.Manutencao;
import dominio.Quadra;

public class QuadraMenu {
  static String tipo;
  static String coberta;
  static String arquibancada;
  static String banco_jogador;
  static int op;
  static String aux;
  static String status;

  public static void exibeMenu() {
    aux = JOptionPane.showInputDialog(
        "Digite o digito da ação da desejada!  \n-----------------------------------------------------\n 1 - Cadastrar \n 2 - Deletar \n 3 - Consultar  \n 4 - Atualizar \n 5 - Agendar Manutenção \n 6 - Sair");
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

        String[] valores5 = { "Desbloqueada", "Bloqueada", };
        status = (String) JOptionPane.showInputDialog(null, "Informe a situação da quadra? ", "quadra",
            JOptionPane.QUESTION_MESSAGE, null, valores5, valores5[0]);

        Quadra q = new Quadra();
        q.setNumero(numero);
        q.setTipo(tipo);
        q.setCoberta(coberta);
        q.setArquibancada(arquibancada);
        q.setBanco(banco_jogador);
        q.setStatus(status);

        boolean reserva = QuadraDAO.cadastrarQuadra(q);

        if (reserva) {
          JOptionPane.showMessageDialog(null, "Quadra cadastrada com sucesso!!!");
        } else {
          JOptionPane.showMessageDialog(null, "Erro ao cadastrar quadra!!!");
        }
      }
        break;

      case 2: {
        
        JOptionPane.showMessageDialog(null, "===== Deletar Quadra =====");
        ArrayList<Quadra> quadras = QuadraDAO.buscarQuadra();

        for (Quadra q : quadras) {
          JOptionPane.showMessageDialog(null, "ID da quadra: [" + q.getId() + "]" + "\nNumero da quadra: "
              + q.getNumero() + "\nStatus da quadra: " + q.getStatus());
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
      }
        break;

      case 3:
        ArrayList<Quadra> quadra = QuadraDAO.buscarQuadra();
        for (Quadra q : quadra) {
          JOptionPane.showMessageDialog(null, "[" + q.getId() + "]" + "Numero: "
              + q.getNumero() + "\nTipo de quadra: " + q.getTipo() + "\nCoberta: " + q.getCoberta() +
              "\nArquibancada: " + q.getArquibancada() + "\nBanco para jogador: " + q.getBanco() + "\nStatus: "
              + q.getStatus());
        }
        break;

      case 4: {
        JOptionPane.showMessageDialog(null, "===== Atualizar Quadra =====");
        ArrayList<Quadra> quadras = QuadraDAO.buscarQuadra();

        for (Quadra q : quadras) {

          JOptionPane.showMessageDialog(null, "ID da quadra: [" + q.getId() + "]" + "\nNumero da quadra: "
              + q.getNumero() + "\nStatus da quadra: " + q.getStatus());
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

        String[] valores5 = { "Desbloqueada", "Bloqueada", };
        status = (String) JOptionPane.showInputDialog(null, "Informe a situação da quadra? ", "quadra",
            JOptionPane.QUESTION_MESSAGE, null, valores5, valores5[0]);

         q.setNumero(numero);
         q.setTipo(tipo);
         q.setCoberta(coberta);
         q.setArquibancada(arquibancada);
         q.setBanco(banco_jogador);
        q.setStatus(status);

        boolean reserva = QuadraDAO.atualizarQuadra(q);

        if (reserva) {
          JOptionPane.showMessageDialog(null, "Quadra cadastrada com sucesso!!!");
        } else {
          JOptionPane.showMessageDialog(null, "Erro ao atualizar quadra!!!");
        }
      }
        break;

      case 5:
        String string = JOptionPane.showInputDialog(
            "Digite o digito da ação da desejada!  \n-----------------------------------------------------\n 1 - Agendar manutenção \n 2 - Deletar manutenção\n 3 - Consultar manutenção \n 4 - Atualizar manutenção\n 5 - Sair");
        int select = Integer.parseInt(string);

        switch (select) {
          case 1: {
            JOptionPane.showMessageDialog(null, "===== Agendar manutenção =====");

            String aux1 = JOptionPane.showInputDialog("Informe o numero da quadra: ");
            int numero = Integer.parseInt(aux1);
            String dia_inicio = JOptionPane.showInputDialog("Digite o dia e mes de iníco: ");
            String dia_fim = JOptionPane.showInputDialog("Digite o dia e mes de termino: ");

            Manutencao m = new Manutencao();
            m.setNumero(numero);
            m.setDia_inicio(dia_inicio);
            m.setDia_fim(dia_fim);

            boolean reserva = ManutencaoDAO.adicionarManutencao(m);

            if (reserva) {
              JOptionPane.showMessageDialog(null, "Manutenção agendada com sucesso!!!");
            } else {
              JOptionPane.showMessageDialog(null, "Erro ao agendar manutenção!!!");
            }
          }
            break;

          case 2: {
            JOptionPane.showMessageDialog(null, "===== Remover Manutenção =====");
                ArrayList<Manutencao> Manutencao = ManutencaoDAO.buscarManutencao();
                
                for (Manutencao m : Manutencao) {
                  JOptionPane.showMessageDialog(null, "ID manutenção: [" + m.getId() + "]" + "\nNumero da quadra: "
                  + m.getNumero() + "\nDia início: " + m.getDia_inicio() + "\nDia fim: " + m.getDia_fim());
                }
                String string1 = JOptionPane.showInputDialog("Digite o ID da reserva que deseja remover: ");
                int id = Integer.parseInt(string1);
                
                Manutencao m = new Manutencao();
                m.setId(id);
                
                boolean removido = ManutencaoDAO.deletarManutencao(m);
                
                 if(removido) {
                     JOptionPane.showMessageDialog(null, "Manutenção removida com sucesso!!!");
                 }else {
                     JOptionPane.showMessageDialog(null, "Erro ao remover manutenção!!!");
                 }
          }
            break;

          case 3: {
            ArrayList<Manutencao> manutencao = ManutencaoDAO.buscarManutencao();
            for (Manutencao m : manutencao) {
              JOptionPane.showMessageDialog(null, "ID manutenção: [" + m.getId() + "]" + "\nDia início: "
                  + m.getDia_inicio() + "\nDia fim: " + m.getDia_fim());
            }
          }
            break;

          case 4: {
            JOptionPane.showMessageDialog(null, "===== Atualizar Quadra =====");
            ArrayList<Manutencao> manutencao = ManutencaoDAO.buscarManutencao();

            for (Manutencao m : manutencao) {
              JOptionPane.showMessageDialog(null, "ID manutenção: [" + m.getId() + "]" + "\nNumero da quadra: "
                  + m.getNumero() + "\nDia início: " + m.getDia_inicio() + "\nDia fim: " + m.getDia_fim());
            }
            String string5 = JOptionPane.showInputDialog("Digite o ID da quadra que deseja atualizar");
            int id = Integer.parseInt(string5);

            Manutencao m = new Manutencao();
            m.setId(id);

            JOptionPane.showMessageDialog(null, "===== Informe as novas característica da quadra  =====");

            String aux3 = JOptionPane.showInputDialog("Informe o numero da quadra: ");
            int numero = Integer.parseInt(aux3);
            String dia_inicio = JOptionPane.showInputDialog("Digite o dia e mes de iníco: ");
            String dia_fim = JOptionPane.showInputDialog("Digite o dia e mes de termino: ");

            m.setNumero(numero);
            m.setDia_inicio(dia_inicio);
            m.setDia_fim(dia_fim);

            boolean reserva = ManutencaoDAO.atualizarManutencao(m);

            if (reserva) {
              JOptionPane.showMessageDialog(null, "Manutenção agendada com sucesso!!!");
            } else {
              JOptionPane.showMessageDialog(null, "Erro ao agendar manutenção!!!");
            }
          }
            break;

          case 5: {
            JOptionPane.showMessageDialog(null, "Saindo!!");
          }
            break;

          default: {
            JOptionPane.showMessageDialog(null, "Ops você digitou algo errado. Saindo!!");
          }
            break;
        }
        break;

      case 6: {
        JOptionPane.showMessageDialog(null, "Saindo!!!");
      }
        break;

      default: {
        JOptionPane.showMessageDialog(null, "Ops você digitou algo errado. Saindo!!");
      }
    }
  }
}
