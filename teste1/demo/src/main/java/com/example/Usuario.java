package com.example;

public class Usuario {
    protected String usuario;
    protected String senha;
    protected boolean verificacao;

    protected Usuario(String usuario, String senha) {
        setUsuario(usuario);
        setSenha(senha);;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senhaVF) {
        this.senha = senhaVF;
    }

    protected boolean verificaUsuario(boolean verificacao) {
        return (usuario.contains("admin") && senha.contains("123"));
    }
}
