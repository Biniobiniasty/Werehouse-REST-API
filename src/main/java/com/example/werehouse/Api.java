package com.example.werehouse;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/werehouse")
@RestController
public class Api {
    private Manager manager;

    @Autowired
    public Api(Manager manager) {
        this.manager = manager;
    }

    @JsonView({ProductDTOView.Normal.class})
    @GetMapping("/all")
    public List<ProductDTO> getAll() {
        return manager.getAll();
    }

    @PostMapping("/new")
    public boolean save(@RequestBody Product product) {
        return manager.save(product);
    }

    @PatchMapping("/update")
    public boolean addAmount(@RequestBody Product product)
    {
        return manager.addAmount(product);
    }
    @PatchMapping("/sub")
    public boolean subAmount(@RequestBody Product product)
    {
        return manager.subAmount(product);
    }


}
