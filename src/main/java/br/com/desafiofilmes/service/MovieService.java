package br.com.desafiofilmes.service;

import br.com.desafiofilmes.entity.Movie;
import br.com.desafiofilmes.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public List<Movie> getMoviesFromAYear(Integer year) {
		return movieRepository.findByYear(year);
	}
}
