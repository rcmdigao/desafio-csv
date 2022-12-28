package br.com.desafiofilmes.controller;

import br.com.desafiofilmes.dto.IntervalWinnersDto;
import br.com.desafiofilmes.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/movies")
public class MovieResource {
	
	@Autowired
	private MovieService service;
	
	@RequestMapping(value = "/awardsinterval", method=RequestMethod.GET)
	public ResponseEntity<IntervalWinnersDto> minMaxIntervalBetweenTwoAwards() {
		return ResponseEntity.ok().body(service.minMaxIntervalBetweenTwoAwards());
	}
}
