package br.com.desafiofilmes.repository;

import br.com.desafiofilmes.entity.MovieStudio;
import br.com.desafiofilmes.entity.MovieStudioId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieStudioRepository extends JpaRepository<MovieStudio, MovieStudioId>{

}
