package br.com.desafiofilmes.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@ToString
public class MovieStudioId implements Serializable {
	
	private static final long serialVersionUID = -5522529450406784648L;

	private Long idMovie;
	
	private Long idStudio;
	
	public MovieStudioId() {}
	
	public MovieStudioId(Long idMovie, Long idStudio) {
		this.idMovie = idMovie;
		this.idStudio = idStudio;
	}

}
