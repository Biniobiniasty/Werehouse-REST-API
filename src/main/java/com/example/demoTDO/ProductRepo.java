package com.example.demoTDO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepo {
    private List<Product> products;
    private Baza baza;

    @Autowired
    public ProductRepo(Baza baza, JdbcTemplate jdbcTemplate) {
        this.baza = baza;
        products = new ArrayList<>();
        jdbcTemplate = jdbcTemplate;
    }

    public Iterable<Product> getAll() {
        return baza.findAll();
    }

    public boolean save(Product product) {
        if ((product.getName() == null) && (product.getName().length() <= 0) && (product.getAmount() <= 0))
            return false;
        if (product.getName().length() < 2)
            return false;

        for (Product x : baza.findAll()) {
            if (x.getName().equals(product.getName()))
                return false;
        }

        baza.save(new Product(product.getName(), product.getAmount(), LocalDate.now(), LocalDate.now()));
        return true;
    }

    public boolean addAmount(Product product) {
        if ((product.getId() < 1) || product.getId() > baza.count())
            return false;
        if (product.getAmount() <= 0)
            return false;


        for (Product x : baza.findAll()) {
            if (x.getId() == product.getId()) {
                long amount = (long) x.getAmount() + (long) product.getAmount();
                if (amount <= (long) Integer.MAX_VALUE) {
                    x.setAmount((int)amount);
                    x.setLastDate(LocalDate.now());
                    baza.save(x);
                    return true;
                }
            }
        }


        return false;
    }

    public boolean subAmount(Product product) {

        if ((product.getId() < 1) || product.getId() > baza.count())
            return false;

        if (product.getAmount() <= 0)
            return false;

        for (Product x : baza.findAll()) {
            if (x.getId() == product.getId()) {
                int amount = x.getAmount() - product.getAmount();
                if (amount >= 0) {
                    x.setAmount(amount);
                    x.setLastDate(LocalDate.now());
                    baza.save(x);
                    return true;
                }
                break;
            }
        }


        return false;
    }
}
