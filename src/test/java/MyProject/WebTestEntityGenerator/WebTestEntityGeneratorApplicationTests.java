package MyProject.WebTestEntityGenerator;

import MyProject.WebTestEntityGenerator.db.entity.RaidArrayFileEntity;
import MyProject.WebTestEntityGenerator.db.repository.RaidArrayFileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

//@SpringBootTest
class WebTestEntityGeneratorApplicationTests {

	@Autowired
	private RaidArrayFileRepository fileRepository;

	@Test
	void contextLoads() {

	}

	@Test
	void testOneEnitty(){
		Optional<RaidArrayFileEntity> optionalUser = fileRepository.findById(30L);
		Assertions.assertTrue(optionalUser.isPresent());
	}

}
