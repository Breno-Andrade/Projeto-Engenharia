package cadastroquadra;

import javax.swing.JOptionPane;

import dao.QuadraDAO;

public class MenuCadastroQuadra{
    public static void main(String[] args) {
        String tipo;
        String coberta;
        String arquibancada;
        String banco;
          JOptionPane.showMessageDialog(null, "===== Cadastro Quadra =====");
                
            String aux = JOptionPane.showInputDialog("Digite o Número: ");
            int numero = Integer.parseInt(aux);

            String[] valores  = {"Saibro", "Tenis rápido","Beath tenis"};
            tipo = (String)JOptionPane.showInputDialog(null, "Escolha um tipo de quadra", "quadra", 
            JOptionPane.QUESTION_MESSAGE, null, valores, valores[0]);
           
            String[] valores2  = {"SIM", "NÃO",};
            coberta = (String)JOptionPane.showInputDialog(null, "Possui cobertura? ", "quadra", 
            JOptionPane.QUESTION_MESSAGE, null, valores2, valores2[0]);
            
            String[] valores3  = {"SIM", "NÃO",};
            arquibancada = (String)JOptionPane.showInputDialog(null, "Possui arquibancada? ", "quadra", 
            JOptionPane.QUESTION_MESSAGE, null, valores3, valores3[0]);
            
            String[] valores4  = {"SIM", "NÃO",};
            banco = (String)JOptionPane.showInputDialog(null, "Possui bancos para os jogadores? ", "quadra", 
            JOptionPane.QUESTION_MESSAGE, null, valores4, valores4[0]);
        
  

      Quadra q = new Quadra();
      q.setNumero(numero);
      q.setTipo(tipo);	
      q.setCoberta(coberta);
      q.setArquibancada(arquibancada);
      q.setBanco(banco);
      
      boolean reserva =  QuadraDAO.reservarQuadra(q);
     
      if(reserva) {
         JOptionPane.showMessageDialog(null, "Reserva cadastrada com sucesso!!!");
      }else {
          JOptionPane.showMessageDialog(null, "Erro ao cadastrar reserva!!!");
      }
    }
}

