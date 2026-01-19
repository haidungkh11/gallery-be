/**
 * ==========================================================================
 * System name: swapcom
 * Version: 1.0
 * Create date: Jul 12, 2022
 * Create by: CBA-MID
 * Copy right (c) 2023 VTB-ITD | CBA-MID. All right reserved.
 * ==========================================================================
 */
package vtb.itd.cba;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
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
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
