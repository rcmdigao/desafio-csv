package br.com.desafiofilmes.controller;

import br.com.desafiofilmes.dto.AwardsRangeDTO;
import br.com.desafiofilmes.entity.AwardInterval;
import br.com.desafiofilmes.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProducerController {

    private final ProducerService producerService;
    private final ProducerConverter producerConverter;

    @GetMapping("/awardsinterval")
    public ResponseEntity<AwardsRangeDTO> findAwardsRange() {
        AwardsRangeDTO response = new AwardsRangeDTO();
        AwardInterval awardIntervals = producerService.getIntervalAwards();
        producerConverter.updateMinAwardsRange(response.getMin(), awardIntervals);
        producerConverter.updateMaxAwardsRange(response.getMax(), awardIntervals);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
