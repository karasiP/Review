package COM.SUT.SA.Group22.iSwap.Repository;

import COM.SUT.SA.Group22.iSwap.entity.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface ProposalRepository extends JpaRepository<Proposal,Long> {
    Proposal findById(long props_id);
}
