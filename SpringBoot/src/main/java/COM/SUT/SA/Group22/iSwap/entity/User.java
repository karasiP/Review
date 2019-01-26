package COM.SUT.SA.Group22.iSwap.entity;
import javax.persistence.*;
//import java.util.*;
import lombok.*;
@Data
@Entity //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Table(name="User") //ชื่อตาราง

public class User {
    @Id // Annotations @Id บอกว่าเป็น Primary key
    @SequenceGenerator(name="user_seq",sequenceName="user_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")
    @Column(name="USER_ID")

    private @NonNull Long user_id;
    private @NonNull String username;



   /* @OneToMany(mappedBy = "user")
    private Set<Review> review;*/


    public User() {}
    public User(Long user_id, String username) { //constructor
        this.user_id = user_id;
        this.username = username;
    }
   /* public void setUsername(String username){
        this.username=username;
    }*/
}