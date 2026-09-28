package br.com.locadora.teste;

import br.com.locadora.model.Moto;

public class TesteMoto{
    public static void main(String[] args){
        System.out.println("---Iniciando teste de moto---");

    Moto m = new Moto("ABC1244", "Honda", "Biz", 80, 125);

    if(m.getPlaca().equals("ABC1244") && m.getCilindradas() == 125){
        System.out.println("Objeto criado");
    } else {
        System.err.println("erro ao criar");
    }

    //se for 4 dias
    double valorEsperado = 330;
    double valorCalculado = m.calcularAluguel(4);
    
    if(valorCalculado == valorEsperado){
        System.out.println("Aluguel é de : " +valorCalculado);
    }else{
        System.err.println("Erro no calc, Esperado: "+valorEsperado + "Recebido: " + valorCalculado);
    }
    System.out.println("Fim do teste.");
    }
}