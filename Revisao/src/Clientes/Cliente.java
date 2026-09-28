package Clientes;

public abstract class Cliente {
    //usar protected para ler em outra classe
    protected String nome;
    protected int cpf;
    

    public Cliente(String nome, int cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public abstract String getCategoria();

    public void imprimirDados(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Cpf: " + this.cpf);
        System.out.println("Categoria: " + this.categoria);        
    }

    //get e set

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getCpf() { return cpf; }
    public void setCpf(int cpf) {this.cpf = cpf; }
    }


