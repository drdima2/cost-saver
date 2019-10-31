package ca.costsaver.entity;

public class Store {
    private Integer storeId;
    private String storeName;


    public Store(Integer id, String storeName) {
        this.storeId = id;
        this.storeName = storeName;
    }


    public boolean isNew() {
        return storeId == null;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getProductName() {
        return storeName;
    }

    public void setProductName(String productName) {
        this.storeName = storeName;
    }
}
