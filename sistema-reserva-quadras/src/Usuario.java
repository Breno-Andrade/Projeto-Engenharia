public class Usuario {
    protected String usuarioVF;
    protected String senhaVF;
    protected boolean verificacao;

    protected Usuario(String usuario, String senha) {
        usuarioVF = usuario;
        senhaVF = senha;
    }

    protected boolean verificaUsuario(boolean verificacao) {
        return (usuarioVF.contains("admin") && senhaVF.contains("123"));
    }
}
