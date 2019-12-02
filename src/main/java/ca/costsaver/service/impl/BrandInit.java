package ca.costsaver.service.impl;

import ca.costsaver.entity.Brand;
import ca.costsaver.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class BrandInit {


    @Autowired
    private static BrandRepository repository;



    public static void init(){


//        repository.save(new Brand("SUPERSTORE","superstore.jpg","https://www.realcanadiansuperstore.ca"));
//        repository.save(new Brand("saveonfoods","saveonfoods.jpg","https://www.saveonfoods.com"));


    }
}
