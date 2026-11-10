package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import product.ImportedProduct;
import product.Product;
import product.UsedProduct;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<Product> list = new ArrayList<>();

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char opc = sc.next().charAt(0);

            sc.nextLine(); // Limpa o buffer após ler o char

            System.out.print("Name: ");
            String name = sc.nextLine(); // Atribui à variável 'name'

            System.out.print("Price: ");
            double price = sc.nextDouble(); // Atribui à variável 'price'

            if (opc == 'c' || opc == 'C') {
                list.add(new Product(name, price));
            } else if (opc == 'u' || opc == 'U') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String dateStr = sc.next();
                LocalDate manufactureDate = LocalDate.parse(dateStr, fmt);
                list.add(new UsedProduct(name, price, manufactureDate));
            } else if (opc == 'i' || opc == 'I') {
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customsFee));
            } else {
                System.out.println("Invalid option! Product not added.");
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product prod : list) {
            System.out.println(prod.priceTag());
        }

        sc.close();
    }
}