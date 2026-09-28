package br.com.locadora.teste;

import br.com.locadora.model.Carro;

public class TesteCarro{
    public static void main(String[] args){
        System.out.println("---Iniciando teste de carro---");

    Carro c = new Carro("ABC1234", "Fiat", "Uno", 
    100, 4);

    if(c.getPlaca().equals("ABC1234") && c.getNumportas() == 4){
        System.out.println("Objeto criado");
    } else {
        System.err.println("erro ao criar");
    }

    //se for 5 dias
    double valorEsperado = 500;
    double valorCalculado = c.calcularAluguel(5);
    
    if(valorCalculado == valorEsperado){
        System.out.println("Aluguel é de : " +valorCalculado);
    }else{
        System.err.println("Erro no calc, Esperado: "+valorEsperado + "Recebido: " + valorCalculado);
    }
    System.out.println("Fim do teste.");
}
}