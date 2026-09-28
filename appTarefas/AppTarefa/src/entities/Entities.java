package entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Entities {
    public String nome;
    public String nomeTaf, categoriaTaf;
    public LocalDate dateVen;

    public Entities(String nome, String nomeTaf, String categoriaTaf, LocalDate dateVen) {
        this.nome = nome;
        this.nomeTaf = nomeTaf;
        this.categoriaTaf = categoriaTaf;
        this.dateVen = dateVen;
    }
    
    LocalDate dateHJ = LocalDate.now();

    public long getDiasRestantes() {
        return ChronoUnit.DAYS.between(dateHJ, dateVen);
    }

    public String getNome(){
        return nome;
    }
    
    public String getCategoriaTaf() {
        return categoriaTaf;
    }

    public String toString(){
        return "A tarefa "
        + nomeTaf 
        + ", "
        + "da categoria "
        + categoriaTaf
        + ", "
        + "irá vencer daqui a: "
        + getDiasRestantes()
        + "dia(s)!";       
    }
}
