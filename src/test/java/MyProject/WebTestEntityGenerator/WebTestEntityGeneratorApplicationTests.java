package MyProject.WebTestEntityGenerator;

import MyProject.WebTestEntityGenerator.db.entity.MyFile;
import MyProject.WebTestEntityGenerator.db.repository.FileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class WebTestEntityGeneratorApplicationTests {

	@Autowired
	private FileRepository fileRepository;

	@Test
	void contextLoads() {

	}

	@Test
	void testOneEnitty(){
		Optional<MyFile> optionalUser = fileRepository.findById(30L);
		Assertions.assertTrue(optionalUser.isPresent());
	}

}
