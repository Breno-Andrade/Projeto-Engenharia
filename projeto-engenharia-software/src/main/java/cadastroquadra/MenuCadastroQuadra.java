package cadastroquadra;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.QuadraDAO;

public class MenuCadastroQuadra{
  static String tipo;
  static String coberta;
  static String arquibancada;
  static String banco_jogador;
  static int op;
  static String aux;
  
  public MenuCadastroQuadra(){
    exibeMenuQuadra();
    verificaOpcao();
}

public static void exibeMenuQuadra(){
  aux = JOptionPane.showInputDialog("Digite o digito da ação da desejada!  \n-----------------------------------------------------\n 1 - Reservar \n 2 - Deletar \n 3 - Consultar reservas \n 4 - Sair");
  op = Integer.parseInt(aux);
}

public static void exibeMenu(){
    aux = JOptionPane.showInputDialog("Digite o digito da ação da desejada!  \n-----------------------------------------------------\n 1 - Reservar \n 2 - Deletar \n 3 - Consultar reservas \n 4 - Sair");
    op = Integer.parseInt(aux);
}
public static void verificaOpcao(){
  switch (op) {
      case 1:
      {
          JOptionPane.showMessageDialog(null, "===== Cadastro Quadra =====");
                
            String aux   = JOptionPane.showInputDialog("Digite o Número: ");
            int numero   = Integer.parseInt(aux);

            String[] valores  = {"Saibro", "Tenis rápido","Bea-th tenis"};
            tipo = (String)JOptionPane.showInputDialog(null, "Escolha um tipo de quadra", "quadra", 
            JOptionPane.QUESTION_MESSAGE, null, valores, valores[0]);
           
            String[] valores2  = {"SIM", "NÃO",};
            coberta = (String)JOptionPane.showInputDialog(null, "Possui cobertura? ", "quadra", 
            JOptionPane.QUESTION_MESSAGE, null, valores2, valores2[0]);
            
            String[] valores3  = {"SIM", "NÃO",};
            arquibancada = (String)JOptionPane.showInputDialog(null, "Possui arquibancada? ", "quadra", 
            JOptionPane.QUESTION_MESSAGE, null, valores3, valores3[0]);
            
            String[] valores4  = {"SIM", "NÃO",};
            banco_jogador = (String)JOptionPane.showInputDialog(null, "Possui bancos para os jogadores? ", "quadra", 
            JOptionPane.QUESTION_MESSAGE, null, valores4, valores4[0]);

      Quadra q = new Quadra();
      q.setNumero(numero);
      q.setTipo(tipo);	
      q.setCoberta(coberta);
      q.setArquibancada(arquibancada);
      q.setBanco(banco_jogador);
      
      boolean reserva =  QuadraDAO.reservarQuadra(q);
     
      if(reserva) {
         JOptionPane.showMessageDialog(null, "Quadra cadastrada com sucesso!!!");
      }else {
          JOptionPane.showMessageDialog(null, "Erro ao cadastrar quadra!!!");
      }
    }break;

    case 2:
    {
      JOptionPane.showMessageDialog(null, "===== Deletar Quadra =====");
      ArrayList<Quadra> quadras = QuadraDAO.buscarReservas();
      
      for (Quadra q : quadras) {
          JOptionPane.showMessageDialog(null, "[" + q.getId() + "]" + q.getNumero());
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
    }
       ArrayList <Quadra> quadra = QuadraDAO.buscarReservas();
          for (Quadra q : quadra) {
            JOptionPane.showMessageDialog(null, "[" + q.getId() + "]" +"Numero: " 
            + q.getNumero() + "\nTipo de quadra: " + q.getTipo() + "\nCoberta: " + q.getCoberta() + 
            "\nArquibancada: " + q.getArquibancada()+ "\nBanco para jogador: " + q.getBanco());
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

