package tn.epi.investissement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan({"tn.epi"})
public class InvestissementApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvestissementApplication.class, args);
    }

}
