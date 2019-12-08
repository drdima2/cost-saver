package ca.costsaver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter @Setter
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String name;





    @ManyToOne()
    @JoinColumn(name = "brand_id",nullable = false)
    //@JsonIgnore
    private Brand brand;




    private String address;

}
