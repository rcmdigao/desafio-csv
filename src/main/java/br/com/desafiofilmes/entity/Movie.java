package br.com.desafiofilmes.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="MOVIE")
@Getter
@Setter
@ToString
public class Movie {
	
	@Id
	@Column(name="ID_MOVIE")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="YEAR", nullable=false)
	private Integer year;
	
	@Column(name="TITLE", nullable=false)
	private String title;
	
	@Column(name="IS_WINNER", nullable=false)
	private Boolean winner;

	@OneToMany(mappedBy="movie", cascade=CascadeType.ALL, orphanRemoval = true, fetch=FetchType.EAGER)
	private Set<MovieStudio> studios = new HashSet<>();
	
	@OneToMany(mappedBy="movie", cascade=CascadeType.ALL, orphanRemoval = true, fetch=FetchType.EAGER)
	private Set<MovieProducer> producers = new HashSet<>();

	public Movie() {}

	public Movie(Integer year, String title, String winner) {
		this.year = year;
		this.title = title;
		this.winner = (winner != null && "yes".equalsIgnoreCase(winner)) ;
	}

}
