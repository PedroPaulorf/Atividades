package alunos;

import java.util.List;

public class AnalisadorDeNotas {
    public static double processarNotas(List<Alunos> listaAlunos) {
        double soma = 0.0;
        for (Alunos aluno : listaAlunos) {
            soma += aluno.getNota();
        }
        return soma / listaAlunos.size();
    }

    public static double maiorNota(List<Alunos> listaAlunos) {
        if (listaAlunos == null || listaAlunos.isEmpty()) {
            return 0.0; // se tiver vazio n retorna
        }
        // inicia com a nota do aluno, ja que pra cada index tem uma nota
        double maior = listaAlunos.get(0).getNota();
        // percorre o restante dos alunos
        for (Alunos aluno : listaAlunos) {
            if (aluno.getNota() > maior) {
                maior = aluno.getNota();// se encontrar um amior aquele vira a nota atual
            }
        }
        return maior;
    }

    public static void exibirNotas(List<Alunos> listaAlunos) {
        System.out.println("\n--- RELATÓRIO DE NOTAS ---");
        for (int i = 0; i < listaAlunos.size(); i++) {
            System.out.println("Aluno [" + (i + 1) + "] - Nota: " + listaAlunos.get(i).getNota());
        }
    }
    public static void ultimasInfs(List<Alunos> listaAlunos){
        System.out.println(" Maior nota: " + maiorNota(listaAlunos));
        System.out.println("Media turma: "+ processarNotas(listaAlunos));
    }
}
