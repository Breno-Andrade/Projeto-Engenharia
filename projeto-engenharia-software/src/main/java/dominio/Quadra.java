package dominio;

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
    public void setNumero(int numero2) {
        this.numero = numero2;
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

    public void setCoberta(String coberta) {
        this.coberta = coberta;
    }

    private String arquibancada;
	public String getArquibancada() {
        return arquibancada;
    }
    
    public void setArquibancada(String arquibancada) {
        this.arquibancada = arquibancada;
    }
   
    private String banco;
    public String getBanco() {
        return banco;
    }
    
    public void setBanco(String banco) {
        this.banco = banco;
    }
    
}
