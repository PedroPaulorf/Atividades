import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import entities.Entities;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("Digite seu nome:");
        String nome = sc.nextLine();

        System.out.println("Digite o nome da tarefa:");
        String nomeTaf = sc.nextLine();

        System.out.println("Digite a categoria da tarefa: ");
        String categoriaTaf = sc.nextLine();

        System.out.println("Digite a data de vencimento: ");
        String dataVen = sc.nextLine();

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateVen = LocalDate.parse(dataVen, fmt);
        Entities appTaf = new Entities(nome, nomeTaf, categoriaTaf, dateVen);

        System.out.println(appTaf);
       sc.close();
    }
}
