package com.bubnii.controller;

import com.bubnii.service.interfaces.CartService;
import com.bubnii.service.interfaces.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class CartAndOrderController {

    private final ProductService productService;
    private final CartService cartService;

    public CartAndOrderController(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @DeleteMapping
    public ResponseEntity clearCart(final HttpSession session) {
        final int userId = (int) session.getAttribute("userId");

        productService.clearCart(userId);

        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity getOrderAndSendEmail(final HttpSession session, @RequestParam("email") final String email) {
        cartService.prepareOrderAndSendEmail(session, email);

        return ResponseEntity.ok().build();
    }
}
