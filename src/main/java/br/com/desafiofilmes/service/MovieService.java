package br.com.desafiofilmes.service;

import br.com.desafiofilmes.dto.AwardWinningProducerDto;
import br.com.desafiofilmes.dto.IntervalWinnersDto;
import br.com.desafiofilmes.entity.Movie;
import br.com.desafiofilmes.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repo;
	
	public IntervalWinnersDto minMaxIntervalBetweenTwoAwards() {
		List<AwardWinningProducerDto> list = createDtoList();
		
		Comparator<AwardWinningProducerDto> comparator = Comparator.comparing(AwardWinningProducerDto::getInterval);
		AwardWinningProducerDto dtoMin = list.stream().min(comparator).get();
		
		AwardWinningProducerDto dtoMax = list.stream().max(comparator).get();
		
		List<AwardWinningProducerDto> listMin = new ArrayList<>();
		List<AwardWinningProducerDto> listMax = new ArrayList<>();
		listMin.add(dtoMin);
		listMax.add(dtoMax);
		
		IntervalWinnersDto interval = new IntervalWinnersDto();
		
		interval.setMax(listMax);
		interval.setMin(listMin);
		
		return interval;
	}
	
	private List<AwardWinningProducerDto> createDtoList() {
		List<Movie> movies = repo.awardWinningProducers();
		Map<String, AwardWinningProducerDto> map = new HashMap<>();
		List<AwardWinningProducerDto> dtos = new ArrayList<>();
		for(Movie movie: movies) {
			AwardWinningProducerDto dto = map.get(movie.getProducer());
			if(dto == null) {
				dto = new AwardWinningProducerDto();
				dto.setProducer(movie.getProducer());
				dto.setPreviousWin(movie.getYear());
				dto.setFollowingWin(movie.getYear());
				dto.setInterval(0);
				map.put(movie.getProducer(), dto);
			} else {
				AwardWinningProducerDto nextDto = new AwardWinningProducerDto();
				nextDto.setProducer(movie.getProducer());
				nextDto.setPreviousWin(dto.getFollowingWin());
				nextDto.setFollowingWin(movie.getYear());
				nextDto.setInterval(movie.getYear() - nextDto.getPreviousWin());
				dtos.add(nextDto);
				map.put(movie.getProducer(), nextDto);
			}
			
		}
		return dtos;
	}
}
