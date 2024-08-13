package com.example.aplicativopontodevenda.controller;

import android.content.Context;
import android.widget.Toast;

import com.example.aplicativopontodevenda.dao.LoginDao;
import com.example.aplicativopontodevenda.model.LoginModel;

import java.util.ArrayList;

public class LoginController {

    private Context context;

    public LoginController(Context context) {
        this.context = context;
    }

    public String salvarLogin(String nome, String email, String senha) {
        try {
            if (nome.equals("") || nome.isEmpty()) {
                return "INFORME SEU NOME PARA CADASTRO!!";
            }
            if (email.equals("") || email.isEmpty()) {
                return "INFORME SEU EMAIL PARA CADASTRO!!";
            }
            if (senha.equals("") || senha.isEmpty()) {
                return "INFORME SUA SENHA PARA CADASTRO!!";
            }
            LoginModel login = LoginDao.getInstancia(context).getByEmail(email);

            if (login != null) {
                return "ESSE EMAIL (" + email + ") JÁ ESTÁ CADASTRADO!";
            } else {
                login = new LoginModel();
                login.setNome_login((nome));
                login.setEmail_login(email);
                login.setSenha_login(senha);

                LoginDao.getInstancia(context).insert(login);
                showToast("Cadastro realizado com sucesso!");
            }


        } catch (Exception ex) {
            return "ERRO AO GRAVAR!!";
        }
        return null;
    }
    public ArrayList<LoginModel> retornarLogin(){
        return LoginDao.getInstancia(context).getAll();
    }

    private void showToast(String mensagem) {
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
    }
}