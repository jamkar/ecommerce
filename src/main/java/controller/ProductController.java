package controller;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import service.ProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> saveProduct(@RequestBody Product product, UriComponentsBuilder ucb) {

        productService.add(product);
        System.out.println("prod id: " + product.getId());
        URI locationUri = ucb.path("/products/").path(String.valueOf(product.getId())).build().toUri();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(locationUri);

        return new ResponseEntity<String>(httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{subCategory}", method = RequestMethod.GET)
    public String getBySubcategory(@PathVariable String subCategory, Model model, HttpServletRequest request) {

        System.out.println("subCategory: " + subCategory);

//        List<Product> products = productService.getBySubCategory(subCategory);
//        model.addAgetSession().persist(user);ttribute("productList", products);

        return "products";
    }

    @RequestMapping(value = "/products/motors", method = RequestMethod.GET)
    public String getMotorsContent(Model model) {

//        List<Product> products = productService.getBySubCategory(null);
//        model.addAttribute("productList", products);

        return "motors";
    }

}
