package product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {

    private LocalDate manufactureDate;

    // Formatador de data compartilhado pela classe
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public UsedProduct() {
        super();
    }

    // Construtor correto com 3 parâmetros recebidos da App
    public UsedProduct(String name, Double price, LocalDate manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag() {
        return getName()
            + " (used) $ "
            + String.format("%.2f", getPrice())
            + " (Manufacture date: "
            + manufactureDate.format(fmt)
            + ")";
    }
}