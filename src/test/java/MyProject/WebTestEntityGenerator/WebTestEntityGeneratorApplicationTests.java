package MyProject.WebTestEntityGenerator;

import MyProject.WebTestEntityGenerator.JpaBeans.Entity.MyFile;
import MyProject.WebTestEntityGenerator.JpaBeans.Repository.FileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
