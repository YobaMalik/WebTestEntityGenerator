package MyProject.WebTestEntityGenerator.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingConfiguration {
    Logger log = LoggerFactory.getLogger("application");
}
