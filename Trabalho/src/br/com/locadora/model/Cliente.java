package br.com.locadora.model;

import java.io.Serializable;

public class Cliente implements Serializable{
    private static final long serialVersionUID = 1L;

    private String nome;
    private String cpf;
    private String endereco;

    public Cliente(String nome, String cpf, String endereco){
    this.nome = nome;
    this.cpf = cpf;
    this.endereco = endereco;
    }   

    public String getNome(){
        return nome;
    }
    public String getCpf(){
        return cpf;
    }
    public String getEndereco(){
        return endereco;
    }
}
