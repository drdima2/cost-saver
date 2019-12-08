package ca.costsaver.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
public class Brand {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String name;

    @Column(name="logo_img")
    private String logoImg;

    @Column(name="web_site_url")
    private String webSiteUrl;

    //@OneToMany(mappedBy = "brand", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    //@OrderBy("finishYear DESC, beginYear DESC, id DESC")
    //@JsonIgnore
    //private List<Store> stores;


    public Brand() {
    }

    public Brand(Integer id, String name, String logoImg, String webSiteUrl) {
        this.id = id;
        this.name = name;
        this.logoImg = logoImg;
        this.webSiteUrl = webSiteUrl;
    }

    public Brand(String name, String logoImg, String webSiteUrl) {
        this.name = name;
        this.logoImg = logoImg;
        this.webSiteUrl = webSiteUrl;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Brand{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
