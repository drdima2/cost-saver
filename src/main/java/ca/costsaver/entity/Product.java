package ca.costsaver.entity;



import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="product_pkey")
    //@SequenceGenerator(name="product_pkey",sequenceName="product_id_seq", allocationSize=1)
    private Integer id;



    @Column(name="bar_code")
    //@NotNull(message = "must be not null")
    //@Size(min=4,max=10/*,message = "min 4, max 10"*/ )
    @NotBlank
    private String barCode;

    @Column(name="product_name")
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
