package com.example.demoTDO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int amount;
    private LocalDate creationDate;
    private LocalDate lastDate;

    public Product(String name, int amount, LocalDate creationDate, LocalDate lastDate)
    {
        this.name = name;
        this.amount = amount;
        this.creationDate = creationDate;
        this.lastDate = lastDate;
    }

}
