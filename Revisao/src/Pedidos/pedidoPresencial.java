package Pedidos;

import Clientes.Cliente;

public class pedidoPresencial extends Pedido {
    protected double taxaServico;
    
    public pedidoPresencial(int codigo, Date data, double valorBase, Cliente cliente, double taxaServico){
        super(codigo, data, valorBase, cliente);
        this.taxaServico = taxaServico;
        
    }

    @Override
    public double calcularTotal(){
        double total = getValorBase() + taxaServico;

        if(getCliente() instanceof clienteVip ){
            total -= 20;
        }
        return Math.max(0, total);
    }
}
