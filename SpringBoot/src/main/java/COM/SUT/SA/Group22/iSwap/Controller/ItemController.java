package COM.SUT.SA.Group22.iSwap.Controller;

import COM.SUT.SA.Group22.iSwap.Repository.ItemRepository;
import COM.SUT.SA.Group22.iSwap.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins =  "http://localhost:4200")

public class ItemController {
    @Autowired private ItemRepository itemRepository;

    @GetMapping("/Item")
    public List<Item> getItem(){

        return itemRepository.findAll().stream().collect(Collectors.toList());
    }
}
