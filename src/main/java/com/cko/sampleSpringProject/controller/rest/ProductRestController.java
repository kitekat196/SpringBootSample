package com.cko.sampleSpringProject.controller.rest;

import com.cko.sampleSpringProject.dao.ProductDAO;
import com.cko.sampleSpringProject.model.Film;
import com.cko.sampleSpringProject.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {
    @Autowired
    ProductDAO productDAO;

    @PostMapping("/add")
    public void addFilm(@RequestParam Products products) {
        productDAO.save(products);
    }

    @GetMapping("/get")
    public Products getFilmById(@RequestParam Long id) {
        return productDAO.findProductsById(id);
    }
    @GetMapping("/all")
    public List<Products> getFilmById() {
        List<Products> products = productDAO.findAll();
        return products;
    }
}
