import java.util.Scanner;

public class CadastroQuadras {

    Scanner ler = new Scanner(System.in);


    protected int numero_quadra;
    protected String tipo_quadra;
    protected String cobertura;
    protected String arquibancada;
    protected String banco;


    public int getNumero_quadra() {
        return numero_quadra;
    }

    public void setNumero_quadra(int numero_quadra) {
        this.numero_quadra = numero_quadra;
    }

    public String getTipo_quadra() {
        return tipo_quadra;
    }

    public void setTipo_quadra(String tipo_quadra) {
        this.tipo_quadra = tipo_quadra;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public String getArquibancada() {
        return arquibancada;
    }

    public void setArquibancada(String arquibancada) {
        this.arquibancada = arquibancada;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public void Mostrar_Opcoes() {
        int num_esc;
        boolean ctz = true;
        String son;

        while (ctz == true) {
            System.out.println("____________Novo cadastro de quadra__________________");
            System.out.println("Insira o número da nova quadra: ");
            this.setNumero_quadra(ler.nextInt());
            System.out.println("Qual o tipo da quadra?: 1. Saibro ------- 2. Rápida -------- 3. Tenis de areia");
            num_esc = ler.nextInt();
            if (num_esc == 1) {
                setTipo_quadra("Saibro");
            } else if (num_esc == 2) {
                setTipo_quadra("Rápida");
            } else {
                setTipo_quadra("Tenis de areia");
            }
            System.out.println("A quadra possui uma cobertura?: 1.Sim ---------- 2.Não");
            num_esc = ler.nextInt();
            if (num_esc == 1) {
                setCobertura("Sim");
            } else if (num_esc == 2) {
                setCobertura("Não");
            }
            System.out.println("A quadra possui uma arquibancada?: 1.Sim ---------- 2.Não");
            num_esc = ler.nextInt();
            if (num_esc == 1) {
                setArquibancada("Sim");
            } else if (num_esc == 2) {
                setArquibancada("Não");
            }
            System.out.println("A quadra possui um banco para os jogadores?: 1.Sim ---------- 2.Não");
            num_esc = ler.nextInt();
            if (num_esc == 1) {
                setBanco("Sim");
            } else if (num_esc == 2) {
                setBanco("Não");
            }
            System.out.println("Deseja cadastrar mais quadras? ('s' para sim 'n' para nao)");
            son = ler.next();
            if (son == "s") {
                ctz = true;
            } else {
                ctz = false;
            }


        }
        System.out.println("-------------------------------------");
    }

    public void consultar_quadras() {

        int consult_num;
        boolean sair = false;
        String condi;

        while (sair == false) {
            System.out.println("Insira o numero da quadra desejada: ");
            consult_num = ler.nextInt();
            if (consult_num == getNumero_quadra()) {
                System.out.println("\n" + "O numero da quadra é:" + getNumero_quadra() + "\n" + "O tipo da quadra é: " + getTipo_quadra() + "\n" + "A quadra possui cobertura? :" + getCobertura() + "\n" + "A quadra possui arquibancada?: " + getArquibancada() + "\n" + "A quadra possui banco para os jogadores?: " + getBanco());
                System.out.println("______________________________________");
            } else {
                System.out.println("Essa quadra não existe");
                System.out.println("Deseja inserir outro numero de quadra??('s' para sim 'n' para não");
                condi = ler.next();
                if (condi == "s") {
                    sair = true;
                } else{
                    sair = false;
                }
            }

        }
    }
}
