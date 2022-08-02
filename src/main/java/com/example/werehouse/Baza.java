package com.example.werehouse;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Baza extends CrudRepository<Product, Long> {
}
