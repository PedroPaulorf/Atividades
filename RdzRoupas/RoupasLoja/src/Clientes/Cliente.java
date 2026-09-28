package Clientes;

public abstract class Cliente {
    protected String nome;
    int cpf;

    public Cliente(String nome, int cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public abstract String getCategoria();

    public void imprimirDados(){
        System.out.println("nome: " +this.nome);
        System.out.println("cpf: " +this.cpf);
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getCpf() { return cpf; }
    public void setCpf(int cpf) {this.cpf = cpf; }

}
