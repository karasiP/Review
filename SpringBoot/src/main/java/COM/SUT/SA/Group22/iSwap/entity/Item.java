package COM.SUT.SA.Group22.iSwap.entity;
import javax.persistence.*;
//import java.util.*;
import lombok.*;
@Entity //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Setter @Getter
@ToString
@EqualsAndHashCode
@Table(name="Item") //ชื่อตาราง
public class Item {
    @Id // Annotations @Id บอกว่าเป็น Primary key
    @SequenceGenerator(name="Item_seq",sequenceName="Item_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Item_seq")
    @Column(name="ITEM_ID")

    private @NonNull Long item_id;
    private @NonNull String name;

    /*@OneToMany(mappedBy = "item")
    private Set<Review> review;*/

    public Item() {}
    public Item(Long item_id,String name) { //constructor
        this.item_id = item_id;
        this.name = name;
    }
}