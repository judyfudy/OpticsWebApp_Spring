package com.bubnii.controller;

import com.bubnii.model.Person;
import com.bubnii.model.Product;
import com.bubnii.service.interfaces.CartService;
import com.bubnii.service.interfaces.PersonService;
import com.bubnii.service.interfaces.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    private final ProductService productService;

    private final PersonService personService;

    public CartController(ProductService productService, PersonService personService) {
        this.productService = productService;
        this.personService = personService;
    }

    @GetMapping
    public String getProductList(Model model, HttpSession session) {
        final int userId = (int) session.getAttribute("userId");

        final Person personInfo = personService.get(userId);

        final List<Product> list = personInfo.getProductList();

        model.addAttribute("personInfo", personInfo);
        model.addAttribute("productList", list);

        return "cartList";
    }


    @PostMapping
    public ResponseEntity addProductToCart(@RequestParam("productId") final String productId, HttpSession session) {
        final int userId = (int) session.getAttribute("userId");

        productService.addProductToCart(userId, Integer.parseInt(productId));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteFromCart(@RequestParam final Integer productId, final HttpSession session) {
        final int userId = (int) session.getAttribute("userId");
        productService.deleteFromCart(productId, userId);
        return ResponseEntity.ok().build();
    }
}
