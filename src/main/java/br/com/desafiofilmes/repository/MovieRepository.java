package br.com.desafiofilmes.repository;

import br.com.desafiofilmes.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	List<Movie> findByYear(Integer year);
}
