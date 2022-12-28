package br.com.desafiofilmes.batch;

import br.com.desafiofilmes.entity.Movie;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<Movie, Movie> {

    @Override
    public Movie process(Movie movie) throws Exception {
    	// To perform some pre-processing on loading csv data
    	return movie;
    }
}
