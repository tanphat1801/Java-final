package com.example.ecommerce.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ecommerce.models.CartItem;
import com.example.ecommerce.models.Category;
import com.example.ecommerce.models.Image;
import com.example.ecommerce.models.OrderItem;
import com.example.ecommerce.models.Product;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @GetMapping(value = { "", "/" })
    public ModelAndView getProducts(Model model) {
        ModelAndView mv = new ModelAndView("admin/product/index");
        List<Product> products = new ArrayList<>();
        List<Category> categories = new ArrayList<>();
        List<OrderItem> orderItems = new ArrayList<>();
        List<CartItem> cartItems = new ArrayList<>();
        List<Image> images = new ArrayList<>();
        long millis1 = System.currentTimeMillis();
        Product product = new Product(
                Long.valueOf(1),
                "Product 1",
                "Lam Dong",
                categories,
                images,
                orderItems,
                cartItems,
                Integer.valueOf(1),
                10,
                10,
                15,
                new Date(millis1)
        );


        images.add(new Image( "image.png", product));
        images.add(new Image("image.png", product));
        images.add(new Image("image.png", product));
        images.add(new Image("image.png", product));

        products.add(product);
        mv.addObject("products", products);
        return mv;
    }

    @GetMapping("/category")
    public ModelAndView getCategories(Model model) {
        ModelAndView mv = new ModelAndView("admin/category/index");
        return mv;
    }
}
