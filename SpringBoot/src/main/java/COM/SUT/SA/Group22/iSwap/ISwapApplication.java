package COM.SUT.SA.Group22.iSwap;

import COM.SUT.SA.Group22.iSwap.entity.*;
import COM.SUT.SA.Group22.iSwap.Repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.stream.Stream;
import java.util.Date;

@SpringBootApplication
public class ISwapApplication {

	public static void main(String[] args){
		SpringApplication.run(ISwapApplication.class,args);
	}

	@Bean
	CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}

	@Bean
	ApplicationRunner init(ReviewRepository reviewRepository, UserRepository userRepository,
						   ProposalRepository proposalRepositorysal, ItemRepository itemRepository) {
		return args -> {

			// User
			Stream.of("Natthakarn", "Songsak", "AungIC").forEach(username -> {
				User user = new User();
				user.setUsername(username);
				userRepository.save(user);
			});
			userRepository.findAll().forEach(System.out::println);

			//Item
			Stream.of("Computer","Telephone").forEach(name -> {
				Item tname = new Item();
				tname.setName(name);
				itemRepository.save(tname);
			});
			itemRepository.findAll().forEach(System.out::println);

			//Proposal
			Stream.of("Yes","No").forEach(status -> {
				Proposal statuss = new Proposal();
				statuss.setStatus(status);
				proposalRepositorysal.save(statuss);

			});
			proposalRepositorysal.findAll().forEach(System.out::println);

			//Review
			Review rat = new Review();
			rat.setUser(userRepository.getOne(1L));
			rat.setItem(itemRepository.getOne(1L));
			rat.setProposal(proposalRepositorysal.getOne(1L));
			rat.setRating(5);
			rat.setComments("So good");
			rat.setReviewdate(new Date());
			reviewRepository.save(rat);
			reviewRepository.findAll().forEach(System.out::println);

			Review rat1 = new Review();
			rat1.setUser(userRepository.getOne(2L));
			rat1.setItem(itemRepository.getOne(1L));
			rat1.setProposal(proposalRepositorysal.getOne(2L));
			rat1.setRating(3);
			rat1.setComments("Very nice,I love it");
			rat1.setReviewdate(new Date());
			reviewRepository.save(rat1);
			reviewRepository.findAll().forEach(System.out::println);

		};
	}
}
