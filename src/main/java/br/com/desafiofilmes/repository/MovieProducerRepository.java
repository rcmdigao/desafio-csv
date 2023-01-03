package br.com.desafiofilmes.repository;

import br.com.desafiofilmes.entity.MovieProducer;
import br.com.desafiofilmes.entity.MovieProducerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieProducerRepository extends JpaRepository<MovieProducer, MovieProducerId> {
	
	@Query(value="select mp from MovieProducer as mp join mp.movie as movie join mp.producer as producer "
			+ "where movie.winner = true order by producer.id, movie.year")
	List<MovieProducer> findByMovieWinnerOrderByProducerId(Boolean isWinner);
	
}
