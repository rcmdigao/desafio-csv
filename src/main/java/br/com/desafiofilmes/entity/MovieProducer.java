package br.com.desafiofilmes.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="MOVIE_PRODUCER")
@Data
public class MovieProducer {
	
	@EmbeddedId
	private MovieProducerId id;
	
	@ManyToOne
	@MapsId("idMovie")
	private Movie movie;
	
	@ManyToOne
	@MapsId("idProducer")
	private Producer producer;
	
	public MovieProducer() {}
	
	public MovieProducer(Movie movie, Producer producer) {
		this.movie = movie;
		this.producer = producer;
		this.id = new MovieProducerId(movie.getId(), producer.getId());
	}

}
