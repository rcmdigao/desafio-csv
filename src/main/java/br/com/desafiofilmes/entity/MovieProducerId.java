package br.com.desafiofilmes.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@ToString
public class MovieProducerId implements Serializable {
	
	private static final long serialVersionUID = -5332423598071950748L;

	private Long idMovie;
	
	private Long idProducer;
	
	public MovieProducerId() {}
	
	public MovieProducerId(Long idMovie, Long idProducer) {
		this.idMovie = idMovie;
		this.idProducer = idProducer;
	}

}
