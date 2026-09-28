package Pedidos;
import java.util.Date;
import Clientes.Cliente;

/*
declarar variavel
montar construtor
funcoes
imprimir resumo
getter e setter

*/
public abstract class Pedido {

    protected int codigo;
    protected Date data;
    protected double valorBase;
    protected Cliente cliente;

    public Pedido(int codigo, Date data, double valorBase, Cliente cliente){
        this.codigo = codigo;
        this.data = data;
        this.valorBase = valorBase;
        this.cliente = cliente;
    }

    public abstract double calcularTotal();

    public void imprimirResumo(){
        System.out.println("O codigo: "+this.codigo);
        System.out.println("A data: "+this.data);
        System.out.println("O valor: "+this.valorBase);
        System.out.println("O cliente: "+this.cliente.getNome());
    }

    //pegar valor 
    public double valorBase(){ return valorBase; }
    public Cliente getCliente() { return cliente; }
    public int getCodigo() { return codigo; }
    public Date getData() { return data; }

}
