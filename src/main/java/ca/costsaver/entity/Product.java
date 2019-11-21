package ca.costsaver.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String barCode;
    private String productName;


    public Product() {
    }

    public Product(Integer id , String barCode, String productName) {
        this.id = id;
        this.barCode = barCode;
        this.productName = productName;
    }


//    public boolean isNew(){
//        return id==null;
//    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("id=").append(id);
        sb.append(", barCode='").append(barCode).append('\'');
        sb.append(", productName='").append(productName).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
