package br.com.locadora.view;

import br.com.locadora.controller.Locadora;
import br.com.locadora.model.*;

import java.util.List;
import java.util.Scanner;
/* cpf para testes: 
    pp - 12345678123
    al - 1234567899
    robertyy - 12345678912

    carros - 
    gol - ABC1222
    onix - ABC1234
    porsche - ABC1233
    africa twin - ABC1111
*/


public class Principal {
    public static void main(String[] args) {
        Locadora controller = new Locadora();
        Scanner teclado = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n -- BEM VINDO A LOCADORA CAR'S --");
            System.out.println("1. Cadastrar Veículo (Carro/Moto)");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Realizar Locação");
            System.out.println("4. Listar Veículos");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = teclado.nextInt();
            teclado.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("1. Carro | 2. Moto");
                    int tipo = teclado.nextInt();
                    teclado.nextLine();

                    System.out.print("Placa: "); String p = teclado.nextLine();
                    System.out.print("Marca: "); String m = teclado.nextLine();
                    System.out.print("Modelo: "); String mod = teclado.nextLine();
                    System.out.print("Valor Diária: "); double val = teclado.nextDouble();

                    if (tipo == 1) {
                        System.out.print("Número de Portas: "); int portas = teclado.nextInt();
                        Carro novoCarro = new Carro(p, m, mod, val, portas);
                        controller.cadastrarVeiculo(novoCarro);
                    } else {
                        System.out.print("Cilindradas: "); int cil = teclado.nextInt();
                        Moto novaMoto = new Moto(p, m, mod, val, cil);
                        controller.cadastrarVeiculo(novaMoto);
                    }
                    System.out.println("Veículo cadastrado!");
                    break;

                case 2:
                    System.out.print("Nome: "); String nome = teclado.nextLine();
                    System.out.print("CPF: "); String cpf = teclado.nextLine();
                    System.out.print("Endereço: "); String end = teclado.nextLine();
                    Cliente c = new Cliente(nome, cpf, end);
                    controller.cadastrarCliente(c);
                    System.out.println("Cliente cadastrado!");
                    break;

                case 3:
                    System.out.print("CPF do Cliente: ");
                    String cCpf = teclado.nextLine();
                    System.out.print("Placa do Veículo: ");
                    String cPlaca = teclado.nextLine();
                    System.out.print("Dias: ");
                    int dias = teclado.nextInt();
                    teclado.nextLine(); 

               
                    Locacao recibo = controller.alugarVeiculo(cCpf, cPlaca, dias);

                    if (recibo != null) {
                        System.out.println("------------------------------");
                        System.out.println("Locação realizada com sucesso!");
                        System.out.printf("VALOR TOTAL: R$ %.2f \n", recibo.getValorTotal());
                        System.out.println("------------------------------");
                    } else {
                        System.out.println("Erro: Cliente ou Veículo não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- VEÍCULOS NO SISTEMA ---");
                    List<Veiculo> frota = controller.getVeiculos();

                    if (frota.isEmpty()){
                        System.out.println("Nenhum veículo cadastrado.");
                    }else {
                        for (Veiculo v : frota){
                            System.out.println(v);
                        }
                    }
                    
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        teclado.close();
    }
}