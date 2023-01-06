package br.com.desafiofilmes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "movie")
@NoArgsConstructor
@Data
public class Movie implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private Long id;

	@NotNull
	@Column(name = "year", length = 255, nullable = false)
	private Long year;

	@NotEmpty
	@Size(max = 255)
	@Column(name = "title", length = 255, nullable = false)
	private String title;

	@NotEmpty
	@Size(max = 255)
	@Column(name = "studio", length = 255, nullable = false)
	private String studio;

	@NotEmpty
	@Size(max = 255)
	@Column(name = "producer", length = 255, nullable = false)
	private String producer;

	@NotNull
	@Column(name = "winner", nullable = false)
	private Boolean winner;

	public Movie(Long year, String title, String studio, String producer, Boolean winner) {
		this.year = year;
		this.title = title;
		this.studio = studio;
		this.producer = producer;
		this.winner = winner;
	}
}
