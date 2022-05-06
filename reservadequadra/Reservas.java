package reservadequadras;

public class Reservas {
            private String nome;
            private String cpf;
            private String dia_mes;
            private String tipo_quadra;
            private String horainicio;
            private String horafim;
            
            public Reservas(String nome, String cpf, String dia_mes, String tipo_quadra, String horainicio, String horafim){
                super();
                this.nome        = nome;
                this.cpf         = cpf;
                this.dia_mes     = dia_mes;
                this.tipo_quadra = tipo_quadra;
                this.horainicio  = horainicio;
                this.horafim     = horafim;
            }

/**
     * @return 
     */
    public String gethorainicio() {
        return horainicio;
    }

    /**
     * @param horainicio 
     */
    public void sethorainicio(String horainicio) {
        this.horainicio = horainicio;
    }
    /**
     * @return 
     */
    public String gethorafim() {
        return horafim;
    }

    /**
     * @param horafim 
     */
    public void sethorafim(String horafim) {
        this.horafim = horafim;
    }
    /**
     * @return 
     */
    public String getnome() {
        return nome;
    }

    /**
     * @param nome 
     */
    public void setnome(String nome) {
        this.nome = nome;
    }

    /**
     * @return 
     */
    public String getcpf() {
        return cpf;
    }

    /**
     * @param cpf 
     */
    public void setcpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return 
     */
    public String getdia_mesi() {
        return dia_mes;
    }

    /**
     * @param dia_mes 
     */
    public void setdia_mes(String dia_mes) {
        this.dia_mes = dia_mes;
    }

    /**
     * @return 
     */
    public String gettipo_quadra() {
        return tipo_quadra;
    }

    /**
     * @param tipo_quadra 
     */
    public void settipo_quadra(String tipo_quadra) {
        this.tipo_quadra = tipo_quadra;
    }
    public String toString(){
        return "Nome: " + nome + "\nCPF: " + cpf + "\nDia e Mês: " + dia_mes + "\nTipo de quadra: " + tipo_quadra + "\nHora início: " + horainicio + "\nHora fim: " + horafim;
    }
}
