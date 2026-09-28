package br.com.usuario.conversor.main;
import br.com.usuario.conversor.coin.Coins;

import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Coins meuConv = new Coins();

        System.out.println("Digite o valor R$: ");
        double real = sc.nextDouble();

        System.err.println("Digite a moeda desejada");
        String escolha = sc.next();

        double resultado = 0;
        //botar a var "Escolha para se criar um switch dentro dela"
        switch (escolha) {
            case "dolar":

                resultado = meuConv.converterMoeda(real, meuConv.usdTaxa);
                break;
            case "jpy":
                resultado = meuConv.converterMoeda(real, meuConv.jpyTaxa);
                break;
            case "euro":
                resultado = meuConv.converterMoeda(real, meuConv.eurTaxa);
                break;
            case "gbp":
                resultado = meuConv.converterMoeda(real, meuConv.gpbTaxa);
                break;
            default:
                System.out.println("Moeda indisponível no momento");
                break;
        }
        System.out.printf("O valor fica: %.4f%n ", resultado);

        sc.close();
    }
}
