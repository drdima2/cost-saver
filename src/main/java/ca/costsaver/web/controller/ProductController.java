package ca.costsaver.web.controller;

import ca.costsaver.entity.Product;
import ca.costsaver.service.ProductService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
@RequestMapping("/product")
public class ProductController {


    private static final Logger log = getLogger(ProductController.class);


    @Autowired
    ProductService productService;

    @GetMapping(value = "/all")
    public ModelAndView listAllProducts(ModelAndView modelAndView) {
        modelAndView.addObject("productList", productService.getAll());
        modelAndView.setViewName("/WEB-INF/JSP/index.jsp");
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
        modelAndView.setViewName("/WEB-INF/JSP/edit-product.jsp");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public String addNewProduct(Product product) {
        int newProductId = productService.save(product).getId();
        log.debug("new Product id: {}", newProductId);
        return "redirect:/product/all";
    }
}
