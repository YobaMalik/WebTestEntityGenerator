package MyProject.WebTestEntityGenerator;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration //(exclude = {SecurityAutoConfiguration.class})
public class WebTestEntityGeneratorApplication  {

	public static void main(String[] args) {
		SpringApplication.run(WebTestEntityGeneratorApplication.class, args);
	}

}
