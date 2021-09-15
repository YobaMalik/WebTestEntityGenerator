package MyProject.WebTestEntityGenerator;


import MyProject.WebTestEntityGenerator.EntityPerson.PersonalityGenerator.EntityFactory;
import MyProject.WebTestEntityGenerator.JpaBeans.Entity.MyFile;
import MyProject.WebTestEntityGenerator.JpaBeans.Repository.MyFileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages  = "MyProject.WebTestEntityGenerator.JpaBeans.Entity")
@ComponentScan(basePackages = {
		"MyProject.WebTestEntityGenerator.ConfigurationClass",
		"MyProject.WebTestEntityGenerator.WebControllers",
		"MyProject.WebTestEntityGenerator.JpaBeans.Service"},
		basePackageClasses = EntityFactory.class)
@EnableJpaRepositories(basePackages = "MyProject.WebTestEntityGenerator.JpaBeans.Repository")
public class WebTestEntityGeneratorApplication  {

	public static void main(String[] args) {
		SpringApplication.run(WebTestEntityGeneratorApplication.class, args);
	}

}
