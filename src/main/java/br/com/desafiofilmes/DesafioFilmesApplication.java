package br.com.desafiofilmes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "br.com.desafiofilmes" })
public class DesafioFilmesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesafioFilmesApplication.class, args);
    }

}
