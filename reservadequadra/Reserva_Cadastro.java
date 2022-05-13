package reservadequadras;

import java.util.ArrayList;

public class Reserva_Cadastro {
    private static ArrayList<Reservas> guarda = new ArrayList<Reservas>(); 

    public static ArrayList<Reservas> getguarda(){
        return guarda;
    }
    public static void adicionar(Reservas quadra) {
        guarda.add(quadra);
    }
    static public String listar() {
        String saida ="";
        int i = 1;
        for (Reservas quadra : guarda){
            saida += "\n\n===============Quadras Reservadas" + (i++) + "===============" + "\n\n";
            saida += quadra.toString();
        }
        return saida;
    }
    public int buscar(String tipo){
        int cont = 0; 
        for(Reservas R : guarda){
            if(R.gettipo_quadra().equalsIgnoreCase(tipo)){
                System.out.println("\n===============Quadras Encontradas===============" + "\n\n" + R);
                cont++; 
            }
        }
        return cont;
    }
}
