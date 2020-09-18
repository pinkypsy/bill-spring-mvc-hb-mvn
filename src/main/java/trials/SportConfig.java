package trials;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("ua.alvin")
@PropertySource("classpath:tariffs.properties")
public class SportConfig {

    @Bean
    public Ci ci(){
        return new Ci();
    }
}
