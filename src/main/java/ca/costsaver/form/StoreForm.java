package ca.costsaver.form;

import ca.costsaver.entity.Brand;
import ca.costsaver.entity.Store;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class StoreForm {

    private Store store;
    private Collection<Brand> brandList;

    public StoreForm(Store store, Collection<Brand> brandList) {
        this.store = store;
        this.brandList = brandList;
    }

    public StoreForm() {
    }
}
