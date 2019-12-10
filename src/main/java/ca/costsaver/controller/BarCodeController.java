package ca.costsaver.controller;

import ca.costsaver.entity.Brand;
import ca.costsaver.entity.Store;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
@SessionAttributes({"brand","store"})
@RequestMapping("/barcode")
public class BarCodeController {


    private static final Logger log = getLogger(BarCodeController.class);



    @GetMapping(value = "/")
    public ModelAndView getBarCodeForm() {
        return new ModelAndView("input-barcode");
    }


    @PostMapping(value = "/barcode")
    public ModelAndView getProductInfo(@ModelAttribute("barCodeStr") String barCodeStr, ModelAndView modelAndView) {
        modelAndView.addObject("productInfo","product-info-test");
        modelAndView.setViewName("input-barcode");
        return modelAndView;
    }

    @PostMapping(value = "/price")
    public ModelAndView addPrice(@ModelAttribute("price") Double price,
                                 @ModelAttribute Store store,
                                 @ModelAttribute Brand brand,
                                 ModelAndView modelAndView) {

        return modelAndView;
    }


}
