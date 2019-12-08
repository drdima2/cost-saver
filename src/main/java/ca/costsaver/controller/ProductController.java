package ca.costsaver.controller;

import ca.costsaver.entity.Product;
import ca.costsaver.service.ProductService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
@RequestMapping("/product")
public class ProductController {


    private static final Logger log = getLogger(ProductController.class);


    @Autowired
    ProductService productService;

    //@GetMapping(value = "/all")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView listAllProducts(ModelAndView modelAndView) {
        modelAndView.addObject("productList", productService.getAll());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
        return "redirect:/product/all";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView editProduct(@PathVariable("id") int id, ModelAndView modelAndView) {
        modelAndView.addObject("product", productService.get(id));
        modelAndView.setViewName("edit-product");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public String addNewProduct(@Valid Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            log.debug("Product is not validated");
            model.addAttribute("productList", productService.getAll());
            return "index";
        }
        int newProductId = productService.save(product).getId();
        log.debug("new Product id: {}", newProductId);
        return "redirect:/product/all";
    }
}
