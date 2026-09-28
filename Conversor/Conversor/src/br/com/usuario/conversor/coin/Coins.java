package br.com.usuario.conversor.coin;

public class Coins {
    public double usdTaxa = 5.15;
    public double eurTaxa = 7.00;
    public double jpyTaxa = 0.30;
    public double gpbTaxa = 6.45;

    public double converterMoeda(double valorReal, double valorMoeda){
        return (valorReal / valorMoeda);
    }
}
