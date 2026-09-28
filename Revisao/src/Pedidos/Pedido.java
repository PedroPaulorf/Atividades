package Pedidos;

import Clientes.Cliente;
import java.util.Date;

public abstract class Pedido {
    private int codigo;
    private Date data; //pega a data
    private double valorBase;
    private Cliente cliente;

    public Pedido(int codigo, Date data, double valorBase, Cliente cliente){
        this.codigo = codigo;
        this.data = data;
        this.valorBase = valorBase;
        this.cliente = cliente;
    }

    public abstract double calcularTotal();

    public void imprimirResumo(){
        System.out.println("O codigo: " +this.codigo );
        System.out.println("A data: " +this.data );
        System.out.println("O valor: " +this.valorBase );
        System.out.println("O cliente: " +this.cliente.getNome());
        System.out.println("Valor total: " + calcularTotal());
    }

    //get e set
    
    public double valorBase() { return valorBase; }
    public Cliente getCliente() {return cliente; }
    public int getCodigo() { return codigo; }
    public Date getData() { return data; }
}
