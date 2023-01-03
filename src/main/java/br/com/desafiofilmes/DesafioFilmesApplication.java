package br.com.desafiofilmes;

import br.com.desafiofilmes.entity.Movie;
import br.com.desafiofilmes.repository.MovieRepository;
import br.com.desafiofilmes.service.ProducerService;
import br.com.desafiofilmes.service.StudioService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


@SpringBootApplication
public class DesafioFilmesApplication {


    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private StudioService studioService;

    @Autowired
    private ProducerService producerService;


    public static void main(String[] args) {
        SpringApplication.run(DesafioFilmesApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext appContext) {
        return args -> {

            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            InputStream in = cl.getResourceAsStream("movielist.csv");
            Reader reader = new InputStreamReader(in);
            Iterable<CSVRecord> records = CSVFormat.RFC4180
                    .withDelimiter(';')
                    .withHeader("year", "title", "studios", "producers", "winner")
                    .parse(reader);

            for (CSVRecord record : records) {
                if (record.getRecordNumber() == 1) {
                    continue;
                }

                String winner = record.get("winner");
                Movie movie = movieRepository.save(new Movie(Integer.valueOf(record.get("year")), record.get("title"), winner));

                String studios = record.get("studios");
                studioService.saveStudios(movie, studios);

                String producers = record.get("producers");
                producerService.saveProducers(movie, producers);
            }

        };
    }

}
