package ca.costsaver.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class Product {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)

    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="product_pkey")
    @SequenceGenerator(name="product_pkey",sequenceName="product_id_seq", allocationSize=1)
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
