package COM.SUT.SA.Group22.iSwap.Controller;

import COM.SUT.SA.Group22.iSwap.Repository.ProposalRepository;
import COM.SUT.SA.Group22.iSwap.entity.Proposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins =  "http://localhost:4200")

public class ProposalController {
    @Autowired private ProposalRepository proposalRepository;

    @GetMapping("/Proposal")
    public List<Proposal> getProposal(){
        return proposalRepository.findAll().stream().collect(Collectors.toList());
    }
}
