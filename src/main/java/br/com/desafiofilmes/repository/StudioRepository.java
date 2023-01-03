package br.com.desafiofilmes.repository;

import br.com.desafiofilmes.entity.Studio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudioRepository extends JpaRepository<Studio, Long>{
	Studio findByName(String name);
}
