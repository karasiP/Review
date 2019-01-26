package COM.SUT.SA.Group22.iSwap.Repository;


import COM.SUT.SA.Group22.iSwap.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface UserRepository extends JpaRepository<User,Long> {
   User findById(long user_id);
}
