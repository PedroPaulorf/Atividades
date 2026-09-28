package br.com.locadora.persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class GerenciadorArquivos {
    public static void salvarDados(List<?> lista, String nomeArquivo){

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))){
            oos.writeObject(lista);
            System.out.println("Dados salvos em: "+ nomeArquivo);
        } catch (IOException e){
            System.err.println("Erro ao salvar" + e.getMessage());
        }
    }

    public static List<?> carregarDados(String nomeArquivo){
        File arquivo = new File(nomeArquivo);

        if(!arquivo.exists()){
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))){
            return (List<?>) ois.readObject();
        } catch (IOException | ClassNotFoundException e){
            System.err.println("Erro ao carregar os dados: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
