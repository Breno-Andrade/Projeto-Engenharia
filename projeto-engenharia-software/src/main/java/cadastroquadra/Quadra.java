package cadastroquadra;

public class Quadra {
    private int id;
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int numero;
	public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    private String tipo;
	public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private String coberta;
	public String getCoberta() {
        return coberta;
    }

    private String arquibancada;
	public String getArquibancada() {
        return arquibancada;
    }

    private String banco;
    public String getBanco() {
        return banco;
    }
    
    public void setBanco(String banco) {
        this.banco = banco;
    }

    public void setCoberta(String coberta2) {
    }

    public void setArquibancada(String arquibancada2) {
    }
    
}
