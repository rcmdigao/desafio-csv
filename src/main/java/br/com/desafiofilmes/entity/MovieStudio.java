package br.com.desafiofilmes.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="MOVIE_STUDIO")
@Getter
@Setter
@ToString
public class MovieStudio {

	@EmbeddedId
	private MovieStudioId id;
	
	@ManyToOne
	@MapsId("idMovie")
	private Movie movie;
	
	@ManyToOne
	@MapsId("idStudio")
	private Studio studio;
	
	public MovieStudio() {}
	
	public MovieStudio(Movie movie, Studio studio) {
		this.movie = movie;
		this.studio = studio;
		this.id = new MovieStudioId(movie.getId(), studio.getId());
	}

}
