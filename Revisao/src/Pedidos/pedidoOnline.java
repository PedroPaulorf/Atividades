package Pedidos;
import java.util.Date;
import Clientes.Cliente;


public class pedidoOnline extends Pedido {
    protected double taxaEntrega;
    protected double descontoPercentual;
    
    public pedidoOnline(int codigo, Date data, Cliente cliente, double valorBase, double taxaEntrega, double descontoPercentual){
        super(codigo, data, valorBase, cliente);
        this.taxaEntrega = taxaEntrega;
        this.descontoPercentual = descontoPercentual;
    }

    @Override
    public double calcularTotal(){
        double total = getValorBase() + taxaEntrega - (getValorBase()* descontoPercentual/ 100);

        if(total < 0 ){
            return 0;
        }
        return total;
    }
}
