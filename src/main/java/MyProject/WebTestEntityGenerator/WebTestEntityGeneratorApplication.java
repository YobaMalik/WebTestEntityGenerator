package MyProject.WebTestEntityGenerator;

import MyProject.WebTestEntityGenerator.Configuration.ConnectorConfig;
import MyProject.WebTestEntityGenerator.Configuration.TemplateConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
@EnableAutoConfiguration (exclude = {SecurityAutoConfiguration.class})
public class WebTestEntityGeneratorApplication  {

	public static void main(String[] args) {
		SpringApplication.run(WebTestEntityGeneratorApplication.class, args);
	}
/*
server.ssl.key-store-type=PKCS12
server.ssl.key-store=classpath:keystore.p12
server.ssl.key-store-password=jebaited
server.ssl.key-store-alias=tomcat
 */
}
