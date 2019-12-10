package ca.costsaver.controller;

import ca.costsaver.entity.Brand;
import ca.costsaver.entity.Store;
import ca.costsaver.service.BrandService;
import ca.costsaver.service.StoreService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
@SessionAttributes("brand")
@RequestMapping("/brand")
public class SelectBrandController {


    private static final Logger log = getLogger(SelectBrandController.class);




    @Autowired
    BrandService brandService;


    @ModelAttribute
    public Brand createBrand(){
        return new Brand();
    }


    @GetMapping(value = "/all")
    public ModelAndView listAllBrands(ModelAndView modelAndView) {
        modelAndView.addObject("brandList", brandService.getAll());
        modelAndView.setViewName("select-brand");
        return modelAndView;
    }


    @GetMapping(value = "/{brandId}")
    public String selectBrand(@PathVariable Integer brandId, Model model) {
        Brand brand = brandService.get(brandId);
        model.addAttribute("brand",brand);
        return "redirect:/store/by-brand";
    }





}
