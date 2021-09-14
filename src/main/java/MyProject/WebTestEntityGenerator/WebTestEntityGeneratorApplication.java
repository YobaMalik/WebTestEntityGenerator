package MyProject.WebTestEntityGenerator;


import MyProject.WebTestEntityGenerator.EntityPerson.PersonalityGenerator.EntityFactory;
import MyProject.WebTestEntityGenerator.JpaTest.Entity.MyFile;
import MyProject.WebTestEntityGenerator.JpaTest.Repository.MyFileRepository;
import MyProject.WebTestEntityGenerator.JpaTest.Service.MyFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@SpringBootApplication
@EntityScan(basePackageClasses = MyFile.class)
@ComponentScan(basePackages = {"MyProject.WebTestEntityGenerator.ConfigurationClass","MyProject.WebTestEntityGenerator"}) //,basePackageClasses = MyFileService.class
@EnableJpaRepositories(basePackageClasses = MyFileRepository.class)
public class WebTestEntityGeneratorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WebTestEntityGeneratorApplication.class, args);
	}


	@Override
	public void run(String... args) {

	}
}
