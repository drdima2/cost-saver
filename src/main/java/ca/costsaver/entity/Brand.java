package ca.costsaver.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class Brand {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)


    private Integer id;

    private String name;






    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Brand{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
