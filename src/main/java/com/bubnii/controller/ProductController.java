package com.bubnii.controller;

import com.bubnii.controller.interceptors.LoggerInterceptor;
import com.bubnii.model.Product;
import com.bubnii.model.ProductType;
import com.bubnii.service.interfaces.ProductService;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {

    private static Logger logger = Logger.getLogger(LoggerInterceptor.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products")
    public String productTypeList(final Model model) {
        final List<ProductType> productTypeList = productService.getAllTypesOfProducts();

        model.addAttribute("productTypes", productTypeList);
        return "products";
    }

    @GetMapping(value = "/getProductsByType")
    @ResponseBody
    public ResponseEntity<List<Product>> getProductsByType(@RequestParam("typeId") final int typeId) {
        return ResponseEntity.ok(productService.getProductsByType(typeId));

    }
}
