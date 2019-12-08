package ca.costsaver.controller;

import ca.costsaver.entity.Brand;
import ca.costsaver.entity.Product;
import ca.costsaver.entity.Store;
import ca.costsaver.form.StoreForm;
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
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
@RequestMapping("/store")
public class StoreController {


    private static final Logger log = getLogger(StoreController.class);


    @Autowired
    StoreService storeService;

    @Autowired
    BrandService brandService;

    @GetMapping(value = "/all")
    public ModelAndView listAllStores(ModelAndView modelAndView) {
        Collection<Store> storeList = storeService.getAll();
        modelAndView.addObject("storeList", storeService.getAll());
        modelAndView.addObject("brandList", brandService.getAll());
        //modelAndView.addObject("storeForm",new StoreForm(new Store(), brandService.getAll()));

        modelAndView.addObject("newStore", new Store());

        modelAndView.setViewName("store");
        return modelAndView;
    }


    @PostMapping(value = "/add")
    public String addStore(@ModelAttribute("newStore") @Valid Store store, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            log.debug("Store is not validated");
            model.addAttribute("storeList", storeService.getAll());
            return "store";
        }

        int newStoreId = storeService.save(store).getId();
        log.debug("new Store id: {}", newStoreId);
        return "redirect:/store/all";
    }


}
