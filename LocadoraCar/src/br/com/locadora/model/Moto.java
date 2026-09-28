package br.com.locadora.model;

public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String placa, String marca, String modelo, double valorDiario, int cilindradas){
        super(placa, marca, modelo, valorDiario);
        this.cilindradas = cilindradas;
}
    public int getCilindradas(){
        return cilindradas;
    }

    @Override
    public double calcularAluguel(int dias){
        return (getValorDiario() * dias) + 10.0; //taxa de risco e diferenciar do carro
    }
    @Override
    public String toString() {
        return super.toString() + " | Tipo: Moto  | Cilindradas: " + this.cilindradas;
}
}
