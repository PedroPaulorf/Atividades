package Clientes;

public class clienteVip extends Cliente {
    private String email;

    public clienteVip(String nome, int cpf, String email){
        super(nome, cpf); //chama o construtor da classe pai
        this.email = email;
    }

    @Override
    public String getCategoria(){
        return "Cliente Vip";
    }

    @Override
    public void imprimirDados(){
        super.imprimirDados();
        System.out.println("Email :"+this.email);
    }

    public String getEmail() {return email;}
    public void setEmail(String email){this.email = email; }
}
