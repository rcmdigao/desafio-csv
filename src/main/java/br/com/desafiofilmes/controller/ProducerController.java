package br.com.desafiofilmes.controller;

import br.com.desafiofilmes.dto.ProducerMinMaxPrizesDTO;
import br.com.desafiofilmes.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("producer")
public class ProducerController {
	
	@Autowired
	private ProducerService producerService;
	
	@GetMapping("awardsinterval")
	public ResponseEntity<ProducerMinMaxPrizesDTO> getAwardsinterval() {
		ProducerMinMaxPrizesDTO dto = producerService.getAwardsinterval();
		
		HttpStatus status = HttpStatus.OK;
		if ( dto.getMax().isEmpty() && dto.getMin().isEmpty() ) {
			status = HttpStatus.NO_CONTENT;
		}
		
		return new ResponseEntity<ProducerMinMaxPrizesDTO>(dto, status);
	}

}
