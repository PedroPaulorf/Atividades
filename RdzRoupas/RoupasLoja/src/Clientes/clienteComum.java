package Clientes;

public class clienteComum extends Cliente{
    private String email;

    public clienteComum(String nome, int cpf, String email){
        super(nome, cpf);
        this.email = email;
    }

    @Override
    public String getCategoria(){
        return "Cliente Comum";
    }

    @Override
    public void imprimirDados(){
        super.imprimirDados();
        System.out.println("email: "+this.email);
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {this.email = email; }
}
