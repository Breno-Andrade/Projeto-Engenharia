package cadastroquadra;

public class Quadra {
    private int id;
    private int numero;
    private String tipo;
    private String coberta;
    private String arquibancada;
    private String banco;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCoberta() {
        return coberta;
    }

    public void setCoberta(String coberta) {
        this.coberta = coberta;
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

}
