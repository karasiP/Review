package COM.SUT.SA.Group22.iSwap.entity;
import javax.persistence.*;
//import java.util.*;
import lombok.*;
@Entity //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Getter @Setter
@ToString
@EqualsAndHashCode
@Table(name="Proposal") //ชื่อตาราง
public class Proposal {
    @Id // Annotations @Id บอกว่าเป็น Primary key
    @SequenceGenerator(name="Proposal_seq",sequenceName="Proposal_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Proposal_seq")
    @Column(name="PROPOSAL_ID")

    private @NonNull Long propos_id;
    private @NonNull String status;

    /*@OneToMany(mappedBy = "proposal")
    private Set<Review> review;*/

    public Proposal() {}
    public Proposal(Long propos_id, String pstatus) { //constructor
        this.propos_id = propos_id;
        this.status=pstatus;
    }
}