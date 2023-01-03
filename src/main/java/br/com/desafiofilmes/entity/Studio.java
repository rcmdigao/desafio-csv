package br.com.desafiofilmes.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="STUDIO")
@Getter
@Setter
public class Studio {
	
	@Id
	@Column(name="ID_STUDIO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME", length=50, unique=true)
	private String name;
	
	@OneToMany(mappedBy="studio", cascade=CascadeType.ALL, orphanRemoval = true)
	private List<MovieStudio> movies = new ArrayList<>();
	
	public Studio() {}
	
	public Studio(String name) {
		this.name = name;
	}
}
