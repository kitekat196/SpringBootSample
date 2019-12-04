package com.cko.sampleSpringProject.controller;
import com.cko.sampleSpringProject.dao.ProductDAO;
import com.cko.sampleSpringProject.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductDAO productDAO;
Long qq;


    @GetMapping("/products/all")
    public ModelAndView allProducts(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allProducts");
        List<Products> productList = productDAO.findAll();
        modelAndView.addObject("products", productList);
        return modelAndView;
    }



    @GetMapping("/products/add")
    public String addProducts(){
        return "addProducts";
    }

    @PostMapping("/products/add")
    public RedirectView addNewProducts(Products products) {
        productDAO.save(products);
        return new RedirectView( "/products/all");
    }



    @GetMapping("/products/edit")
    public ModelAndView editProducts(Long id){
        ModelAndView modelAndView = new ModelAndView();
        Products products = productDAO.findProductsById(id);
        modelAndView.addObject("products", products);
        modelAndView.setViewName("editProducts");
        return modelAndView;
    }
    @PostMapping("/products/edit")
    public RedirectView editFilm(Products products) {
        productDAO.save(products);
        return new RedirectView( "/editProducts");
    }
    @GetMapping("/products/delete")
    public RedirectView Delete(@RequestParam long id){
        Products products = productDAO.findProductsById(id);
        if(products.getAmount() > 0) {
            products.setAmount(products.getAmount() - 1);
            productDAO.save(products);
        }

        return new RedirectView("/products/all");
    }


    @GetMapping("/products/buy")
    public ModelAndView ProcBuy(@RequestParam Long id){
        ModelAndView modelAndView = new ModelAndView();
        Products products = productDAO.findProductsById(id);
        qq = products.getId();
        modelAndView.addObject("product", products);
        modelAndView.setViewName("productPage");
        return  modelAndView;
    }
    @PostMapping("/products/buy")
    public RedirectView Buy(int count){
        Products products = productDAO.findProductsById(qq);
        if(products.getAmount() > count){
            products.setAmount(products.getAmount() - count);
            productDAO.save(products);
            return new RedirectView("/products/tenQ");
        } else if(products.getAmount() == count){
            productDAO.deleteById(qq);
            return new RedirectView("/products/tenQ");
        } else {
            return new RedirectView("/products/error");
        }
    }
    @GetMapping("products/tenQ")
    public String tenQ(){
        return "ProductTenQ";
    }

    @GetMapping("products/error")
    public String error(){
        return "ProductError";
    }

}
