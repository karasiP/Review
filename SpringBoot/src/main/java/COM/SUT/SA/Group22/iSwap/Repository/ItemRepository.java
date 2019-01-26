package COM.SUT.SA.Group22.iSwap.Repository;

import COM.SUT.SA.Group22.iSwap.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface ItemRepository extends JpaRepository<Item,Long> {
    Item findById(long item_id);
}
