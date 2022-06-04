package dominio;

public class Usuario {
    private String usuario;
    private String senha;

    public Usuario(String usuario, String senha) {
        setUsuario(usuario);
        setSenha(senha);;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senhaVF) {
        this.senha = senhaVF;
    }

    public boolean verificaUsuario(boolean verificacao) {
        return (usuario.contains("admin") && senha.contains("123"));
    }
}
