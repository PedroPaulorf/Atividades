package br.com.locadora.model;

import java.io.Serializable;;

public class Locacao implements Serializable{
    private static final long serialVersionUID = 1L;

    private Cliente cliente;
    private Veiculo veiculo;
    private int dias;
    private double valorTotal;

    public Locacao(Cliente cliente, Veiculo veiculo, int dias){
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dias = dias;

        this.valorTotal = veiculo.calcularAluguel(dias);
    }

    public Cliente getCliente(){
        return cliente;
    }
    public Veiculo getVeiculo(){
        return veiculo;
    }
    public int getDias(){
        return dias;
    }
    public double getValorTotal(){
        return valorTotal;
    }
    @Override
    public String toString() {
        return "Cliente: " + cliente.getNome() + 
               " | Veículo: " + veiculo.getModelo() + 
               " (" + veiculo.getPlaca() + ")" +
               " | Total: R$ " + String.format("%.2f", valorTotal);
    }
}
