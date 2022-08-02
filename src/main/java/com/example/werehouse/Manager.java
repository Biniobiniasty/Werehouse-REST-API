package com.example.werehouse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Manager {

    private ProductRepo productRepo;
    private ModelMapper modelMapper;

    @Autowired
    public Manager(ModelMapper modelMapper, ProductRepo productRepo) {
        this.productRepo = productRepo;
        this.modelMapper = modelMapper;

    }

    public List<ProductDTO> getAll() {
        List<ProductDTO> products = new ArrayList<>();
        for (Product product : productRepo.getAll()) {
            products.add(new ProductDTO(product.getId(), product.getName(), product.getAmount(), product.getCreationDate(), product.getLastDate()));
        }
        return products;
    }

    public boolean addAmount(Product product) {
        return productRepo.addAmount(product);
    }

    public boolean save(Product product) {
        return productRepo.save(product);
    }

    public boolean subAmount(Product product) {
        return productRepo.subAmount(product);
    }
}
