package br.com.desafiofilmes.service;

import br.com.desafiofilmes.entity.Movie;
import br.com.desafiofilmes.entity.MovieStudio;
import br.com.desafiofilmes.entity.Studio;
import br.com.desafiofilmes.repository.MovieStudioRepository;
import br.com.desafiofilmes.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class StudioService {
	
	@Autowired
	private StudioRepository studioRepository;
	
	@Autowired
	private MovieStudioRepository movieStudioRepository;
	
	public void saveStudios(Movie movie, String studios) {
		for (String strStudio : studios.split(",|\\ and ")) {
			Studio studio = new Studio(strStudio.trim());

			Example<Studio> example = Example.of(studio); 

			if (studioRepository.exists(example)) {
				studio = studioRepository.findByName(strStudio.trim());
			} else {
				studio = studioRepository.save(studio);
			}

			movieStudioRepository.save(new MovieStudio(movie, studio));
		}
	}

}
