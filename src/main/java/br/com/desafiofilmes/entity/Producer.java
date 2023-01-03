package br.com.desafiofilmes.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="PRODUCER")
@Getter
@Setter
public class Producer {
	
	@Id
	@Column(name="ID_PRODUCER")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME", length=50, nullable=false)
	private String name;
	
	@OneToMany(mappedBy="producer", cascade=CascadeType.ALL, orphanRemoval = true)
	private List<MovieProducer> movies = new ArrayList<>();
	
	public Producer() {}
	
	public Producer(String name) {
		this.name = name;
	}
	
}
