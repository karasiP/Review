package COM.SUT.SA.Group22.iSwap.Controller;

import COM.SUT.SA.Group22.iSwap.entity.*;
import COM.SUT.SA.Group22.iSwap.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java. util. regex. Pattern;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;
@RestController

@CrossOrigin(origins =  "http://localhost:4200")
public class ReviewController {

    @Autowired     private ReviewRepository reviewRepository;
    @Autowired     private UserRepository userRepository;
    @Autowired     private ProposalRepository proposalRepository;
    @Autowired     private ItemRepository itemRepository;

    ReviewController(ReviewRepository repository){

        this.reviewRepository = repository;
    }

    // Review
    @GetMapping("/review")
    public List<Review> getReview(){

        return reviewRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/review/{reviewId}")
    public Review getReviewById(@PathVariable Long reviewId){

        return reviewRepository.findById(reviewId).get();
    }

    @GetMapping("/user/{userId}")
    public User getUserById (@PathVariable Long userId){

        return userRepository.findById(userId).get();
    }

    @GetMapping("//{itemId}")
    public Item getItemById (@PathVariable Long itemId){

        return itemRepository.findById(itemId).get();
    }

    @GetMapping("//{propId}")
    public Proposal getPropId (@PathVariable Long propId){

        return proposalRepository.findById(propId).get();
    }

    @PostMapping("/review/create/{user_id}/{item_id}/{propos_id}/{rating}/{comments}")
    public Review createReview(Review r, @PathVariable String comments, @PathVariable Long user_id, @PathVariable Long item_id,
                               @PathVariable int rating, @PathVariable Long propos_id){


        r.setUser(userRepository.findById(user_id).get());
        r.setItem(itemRepository.findById(item_id).get());
        r.setProposal(proposalRepository.findById(propos_id).get());
        r.setComments(comments);
        r.setRating(rating);
        r.setReviewdate(new Date());
        return this.reviewRepository.save(r);
    }
}