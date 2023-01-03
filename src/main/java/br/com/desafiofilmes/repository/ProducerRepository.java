package br.com.desafiofilmes.repository;

import br.com.desafiofilmes.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository extends JpaRepository<Producer, Long> {
	
	Producer findByName(String name);
	
}
