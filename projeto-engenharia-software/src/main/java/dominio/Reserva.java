package dominio;

public class Reserva {
	private int id;
	private String nome;
	private String cpf;
	private String tipo_quadra;
	private String dia_mes;
	private String periodo;
	private String hora_inicio;
	private String hora_termino;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTipoQuadra() {
		return tipo_quadra;
	}
	public void setTipoQuadra(String tipo_quadra) {
		this.tipo_quadra = tipo_quadra; 
	}

	public String getDia_mes() {
		return dia_mes;
	}

	public void setDia_mes(String dia_mes) {
		this.dia_mes = dia_mes;
	}

	public String getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public String getHora_termino() {
		return hora_termino;
	}

	public void setHora_termino(String hora_termino) {
		this.hora_termino = hora_termino;
	}
}

