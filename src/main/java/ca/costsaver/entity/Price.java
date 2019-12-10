package ca.costsaver.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter @Setter
@Entity
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @ManyToOne()
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "store_id",nullable = false)
    private Store store;


    private Double price;

    private LocalDateTime date;

}
