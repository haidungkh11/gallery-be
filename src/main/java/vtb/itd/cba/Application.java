package vtb.itd.cba;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;



// TODO: Auto-generated Javadoc

/**
 * The Class Application.
 */
@SpringBootApplication
@EnableTransactionManagement
public class Application extends SpringBootServletInitializer {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        System.out.println(encoder.encode("1"));
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
