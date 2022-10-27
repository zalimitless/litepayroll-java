package com.payroll.e.litepayroll;

import com.payroll.constants.Gender;
import com.payroll.constants.ProfileColour;
import com.payroll.constants.Salutation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(
                    new EmployeeDTO(
                            69420l,
                            "Johan Vincent",
                            "De Lange",
                            Salutation.Mr.getID(),
                            Gender.Male.getValue(),
                            45635.45f,
                            ProfileColour.Blue.getColourID())));

            log.info("Preloading " + repository.save(
                    new EmployeeDTO(123456l,
                            "Brandon Superman",
                            "Kent",
                            Salutation.Dr.getID(),
                            Gender.Male.getValue(),
                            45635.45f,
                            ProfileColour.Default.getColourID())));
        };
    }
}
