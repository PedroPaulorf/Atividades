package br.com.locadora.model;

import java.io.Serializable;

public abstract class Veiculo implements Alugavel, Serializable {
    private static final long serialVersionUID = 1L;

    private String placa;
    private String marca;
    private String modelo;
    private double valorDiario;
    private boolean disponivel = true;

    public Veiculo(String placa, String marca, String modelo, double valorDiario){ 
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.valorDiario = valorDiario;
    }

    public String getPlaca() { return placa; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public double getValorDiario() { return valorDiario; }
    

    public abstract double calcularAluguel(int dias);

    @Override 
    public String toString(){
        String status = this.disponivel ? "[livre]" : "[alugado]";
        return status + " Placa: " + this.placa + 
               " | Modelo: " + this.modelo + 
               " | Marca: " + this.marca + 
               " | Diária: R$ " + this.valorDiario;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
