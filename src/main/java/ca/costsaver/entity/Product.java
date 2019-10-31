package ca.costsaver.entity;

public class Product {
    private Integer id;
    private String barCode;
    private String productName;


    public Product(Integer id, String barCode, String productName) {
        this.id = id;
        this.barCode = barCode;
        this.productName = productName;
    }


    public boolean isNew() {
        return id == null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
