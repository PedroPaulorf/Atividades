package br.com.locadora.model;

public class Carro extends Veiculo{
    private int numPortas;

    public Carro(String placa, String marca, String modelo, double valorDiario, int numPortas){
        super(placa, marca, modelo, valorDiario);
        this.numPortas = numPortas;
}

    public int getNumportas(){
        return numPortas;
    }
    @Override
    public double calcularAluguel(int dias){
        return getValorDiario() * dias;
    }

    @Override
    public String toString(){
        return super.toString() + "| Tipo carro | Portas: " + this.numPortas;
    }
}
