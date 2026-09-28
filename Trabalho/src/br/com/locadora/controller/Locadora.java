package br.com.locadora.controller;

import br.com.locadora.model.*;
import br.com.locadora.persistence.GerenciadorArquivos;
import java.util.List;

public class Locadora {
    private List<Veiculo> veiculos;
    private List<Cliente> clientes;
    private List<Locacao> locacoes;

    @SuppressWarnings("unchecked")
    public Locadora(){
        this.veiculos = (List<Veiculo>) GerenciadorArquivos.carregarDados("veiculos.dat");
        this.clientes = (List<Cliente>) GerenciadorArquivos.carregarDados("clientes.dat");
        this.locacoes = (List<Locacao>) GerenciadorArquivos.carregarDados("locacoes.dat");

    }

    public void cadastrarVeiculo(Veiculo v){
        veiculos.add(v);
        GerenciadorArquivos.salvarDados(veiculos, "veiculos.dat");
    }
    public void cadastrarCliente(Cliente c){
        clientes.add(c);
        GerenciadorArquivos.salvarDados(clientes, "clientes.dat");
    }

    public List<Veiculo> getVeiculos(){
        return veiculos;
    }

    public Veiculo buscarVeiculo(String placa){
        for (Veiculo v : veiculos){
            if (v.getPlaca().equalsIgnoreCase(placa)){
                return v;
            }
        }
        return null;
    }

    public Cliente buscarCliente(String cpf){
        for(Cliente c : clientes){
            if (c.getCpf().equals(cpf)){
                return c;
            }
        }
        return null;
    }

    public Locacao alugarVeiculo(String cpf, String placa, int dias) {
        
        Cliente cliente = buscarCliente(cpf);
        Veiculo veiculo = buscarVeiculo(placa);

        if (cliente == null || veiculo == null) {
            System.out.println("Erro: Cliente ou Veículo não encontrado.");
            return null;
        }
        if (veiculo.isDisponivel() == false) {
            System.out.println("Erro, O veículo " + veiculo.getModelo() + " já está alugado!");
            return null;
        }


        Locacao novaLocacao = new Locacao(cliente, veiculo, dias);
        locacoes.add(novaLocacao);

        
        veiculo.setDisponivel(false);
        
        GerenciadorArquivos.salvarDados(locacoes, "locacoes.dat");
        GerenciadorArquivos.salvarDados(veiculos, "veiculos.dat");

        return novaLocacao;

        
    }
}