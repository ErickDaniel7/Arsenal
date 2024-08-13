package com.example.aplicativopontodevenda.model;

public class LoginModel {

    private int id;
    private String nome_login;
    private String email_login;
    private String senha_login;


    public LoginModel(){

    }

    public LoginModel(int id, String nome_login, String senha_login, String email_login) {
        this.id = id;
        this.nome_login = nome_login;
        this.senha_login = senha_login;
        this.email_login = email_login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_login() {
        return nome_login;
    }

    public void setNome_login(String nome_login) {
        this.nome_login = nome_login;
    }

    public String getSenha_login() {
        return senha_login;
    }

    public void setSenha_login(String senha_login) {
        this.senha_login = senha_login;
    }

    public String getEmail_login() {
        return email_login;
    }

    public void setEmail_login(String email_login) {
        this.email_login = email_login;
    }
}
