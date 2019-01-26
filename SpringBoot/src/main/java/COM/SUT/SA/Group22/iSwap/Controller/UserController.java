package COM.SUT.SA.Group22.iSwap.Controller;

import COM.SUT.SA.Group22.iSwap.entity.*;
import COM.SUT.SA.Group22.iSwap.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins =  "http://localhost:4200")

public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/User")
    public List<User> getUser() {

        return userRepository.findAll().stream().collect(Collectors.toList());
    }
}
