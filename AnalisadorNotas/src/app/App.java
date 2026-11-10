package app;

import alunos.Alunos;
import alunos.AnalisadorDeNotas;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        ;

        List<Alunos> listaAlunos = new ArrayList<>();

        System.out.println("Olá! Digite a quantidade de alunos: ");
        int al = sc.nextInt();

        for (int i = 0; i < al; i++) {
            System.out.println("Digite  a nota do aluno[" + i + "]: ");
            double nota = sc.nextDouble();

            // armazena a nota
            Alunos aluno = new Alunos(nota);
            // add a lista
            listaAlunos.add(aluno);

        }

        AnalisadorDeNotas.exibirNotas(listaAlunos);
        AnalisadorDeNotas.ultimasInfs(listaAlunos);

        sc.close();
    }
}
