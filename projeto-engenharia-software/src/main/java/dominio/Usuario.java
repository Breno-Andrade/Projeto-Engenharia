package dominio;

public class Usuario {
    private String nome;
    private String usuariovf;
    private String senhavf;
    private String email;
    private String senha;
    private String nivel_permissao;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivel_permissao() {
        return nivel_permissao;
    }

    public void setNivel_permissao(String nivel_permissao) {
        this.nivel_permissao = nivel_permissao;
    }

    public String getUsuariovf() {
        return usuariovf;
    }

    public void setUsuariovf(String usuariovf) {
        this.usuariovf = usuariovf;
    }

    public String getSenhavf() {
        return senhavf;
    }

    public void setSenhavf(String senhavf) {
        this.senhavf = senhavf;
    }

    public Usuario(String usuariovf, String senhavf) {
        setUsuariovf(usuariovf);
        setSenhavf(senhavf);
    }
   

    public boolean verificaUsuario(boolean verificacao) {
        return (usuariovf.equals("admin") && senhavf.equals("123"));
    }
}
