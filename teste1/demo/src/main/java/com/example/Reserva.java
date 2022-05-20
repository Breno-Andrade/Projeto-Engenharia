package com.example;

import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;

    
    import javax.swing.JOptionPane;
    
    public class Reserva {
        public static void main (String[] args) {
            
            String aux = JOptionPane.showInputDialog("Digite o digito da ação da desejada! \n[1] Reservar quadra | [2] Deletar quadra | [3] Editar reserva | \n[4] Consultar quadras reservadas | [5] Sair |");
            int op = Integer.parseInt(aux);
            switch (op) {
                case 1:
                {
                    reservarQuadras();break;
                }
                case 2: 
                {
                    deletarReservaQuadras();break;
                }
                case 3:
                { 
                    atualizarReservaQuadras();break;
                }
                case 4: 
                {
                    buscarReservasQuadras();break;
                }
                case 8:
                {
                    JOptionPane.showMessageDialog(null, "Saindo!!"); break;
                }
                default:
                {
                    JOptionPane.showMessageDialog(null, "Ops você digitou algo errado. Saindo");
                }
            }
        }
        
        public static void buscarReservasQuadras(){
            try {
                
                Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost/reserva", "postgres", "017017");
                
                PreparedStatement stmt = conexao.prepareStatement ("SELECT * FROM public.reservaquadra");
                
                ResultSet rs =stmt.executeQuery();
            
                while (rs.next()) {
                    int id = rs.getInt ("id");
                    String nome= rs.getString("nome");
                    String cpf = rs.getString("cpf");
                    String tipo_quadra = rs.getString("tipo_quadra");
                    String dia_mes  = rs.getString("dia_mes");
                    String hora_inicio = rs.getString("hora_inicio");
                    String hora_termino = rs.getString("hora_termino");
      
                    System.out.println("Id:"+id);
                    System.out.println("nome: " + nome);
                    System.out.println("cpf:" + cpf);
                    System.out.println("tipo_quadra :" + tipo_quadra );
                    System.out.println("dia_mes :" + dia_mes );
                    System.out.println("Senha:" + hora_inicio);
                    System.out.println("Senha:" + hora_termino);
                    System.out.println("");
                }
                }catch (SQLException e){
                    
                    e.printStackTrace();
                }
            
            }
    
        public static void reservarQuadras(){
    
            
            String nome       = JOptionPane.showInputDialog("Digite seu nome: ");
            String cpf        = JOptionPane.showInputDialog("Digite seu cpf: ");
            //String[] valores  = {"Saibro", "Tenis rápido","Beath tenis"};
            //String seletor    = (String)JOptionPane.showInputDialog(null, "Escolha um tipo de quadra", "quadra", JOptionPane.QUESTION_MESSAGE, null, valores, valores[0]);
            String seletor    = JOptionPane.showInputDialog("Digite o tipo da quadra: ");
            String dia_mes    = JOptionPane.showInputDialog("Digite o dia e mês (ex: 00/00): ");
            String horainicio = JOptionPane.showInputDialog("Digite a hora de inicio desejada: (funcionamento = 06:00 até 22:00) ");
            String horafim    = JOptionPane.showInputDialog("Digite a hora de termino desejada: ");
    
            try {
                Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost/reserva", "postgres", "017017");
                PreparedStatement stmt = conexao.prepareStatement ("INSERT INTO reservaquadra (nome, cpf, tipo_quadra, dia_mes, hora_inicio, hora_termino) values (?,?,?,?,?,?)");
                
                stmt.setString(1, nome);
                stmt.setString(2, cpf);
                stmt.setString(3, seletor);
                stmt.setString(4, dia_mes);
                stmt.setString(5, horainicio);
                stmt.setString(6, horafim);
                
                
                int rowsAffected = stmt.executeUpdate();
                
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Reserva de quadra inserida com sucesso!!");
                }else { 
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar reserva de quadra.");
                }
          }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        
        public static void deletarReservaQuadras () {
    
            buscarReservasQuadras();
            
            String aux = JOptionPane.showInputDialog("Digite o id da quadra que deseja remover: ");
            int id = Integer.parseInt(aux);
    
            try {
                Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost/reserva", "postgres", "017017");  
                PreparedStatement stmt = conexao.prepareStatement("DELETE FROM public.reservaquadra WHERE id = ?");
    
                    stmt.setInt(1, id);
    
                    int rowsAffected = stmt.executeUpdate();
    
                    if (rowsAffected > 0){
                        JOptionPane.showMessageDialog(null, "Reserva de quadra deletada com sucesso!!!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao deletar a reserva. Tente novamente!!!");
                    }        
              } catch (SQLException e ){
                  e.printStackTrace();
            }
        }
    
        public static void atualizarReservaQuadras() {
            buscarReservasQuadras();
            
            String aux = JOptionPane.showInputDialog("Digite o id da reserva que deseja alterar os dados: ");
            int id = Integer.parseInt(aux);
            
            String nome         = JOptionPane.showInputDialog("Digite o novo nome: ");
            String cpf 			= JOptionPane.showInputDialog("Digite o novo cpf: ");
            String tipo_quadra  = JOptionPane.showInputDialog("Digite a nova quadra: ");
            String dia_mes  	= JOptionPane.showInputDialog("Digite o novo dia e mes");
            String hora_inicio  = JOptionPane.showInputDialog("Digite a nova hora de inicio: ");
            String hora_termino = JOptionPane.showInputDialog("Digite o nova hora de termino: ");
            
            try {
                Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost/reserva", "postgres", "017017");
                PreparedStatement stmt = conexao.prepareStatement("UPDATE public.reservaquadra SET nome = ?, cpf = ?, tipo_quadra = ?, dia_mes = ?, hora_inicio = ?, hora_termino = ?  WHERE id = ?");
                
                stmt.setString(1, nome);
                stmt.setString(2, cpf);
                stmt.setString(3, tipo_quadra);
                stmt.setString(4, dia_mes);
                stmt.setString(5, hora_inicio);
                stmt.setString(6, hora_termino);
                stmt.setInt(7, id);
                
                int rowsAffected = stmt.executeUpdate();
                
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Os dados foram atualizados com sucesso!!!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados");
                }
            } catch (SQLException e ){
                  e.printStackTrace(); 
            }
        }
    } 
