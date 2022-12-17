package com.example.ecommerce.controllers;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.ecommerce.models.Image;
import com.example.ecommerce.models.Product;
import com.example.ecommerce.repositories.ImageRepository;
import com.example.ecommerce.services.ProductService;

@RequestMapping("/admin/product")
@Controller
public class ProductController {
    private final ProductService productService;
    private final ImageRepository imageRepository;

    @Autowired
    public ProductController(ProductService productService, ImageRepository imageRepository) {
        this.productService = productService;
        this.imageRepository = imageRepository;
    }

    @PostMapping("/create")
    public void create(@RequestParam("imagesName") MultipartFile[] images, @ModelAttribute Product product)
            throws IOException {
        ArrayList<Image> imgList = new ArrayList<>();
        for (MultipartFile img : images) {
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(img.getOriginalFilename()));
            Path pathCurrent = FileSystems.getDefault().getPath("").toAbsolutePath();
            Path path = Paths.get(pathCurrent+"/src/main/resources/uploads/"+fileName);
            Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            imgList.add(new Image(fileName, product));
        }
        product.setImages(imgList);
        System.out.println(product);
        productService.addNewProduct(product);
    }

    @GetMapping("/{id}")
    public ModelAndView updateView(Model model) {
        ModelAndView mv = new ModelAndView("admin/product/update");
        return mv;
    }

    @PostMapping("/update")
    public void update(Model model) {

        return;
    }

    @PostMapping("/delete")
    public void delete(Model model) {

        return;
    }
}
