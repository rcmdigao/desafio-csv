package br.com.desafiofilmes.controller;

import br.com.desafiofilmes.dto.ProducerAwardDTO;
import br.com.desafiofilmes.entity.AwardInterval;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProducerConverter {

    public void updateMinAwardsRange(List<ProducerAwardDTO> minRange, AwardInterval awardInterval) {
        awardInterval.getMin().forEach(producerInterval -> {
            ProducerAwardDTO record = new ProducerAwardDTO();
            record.setFollowingWin(producerInterval.getFollowingWin());
            record.setInterval(producerInterval.getInterval());
            record.setPreviousWin(producerInterval.getPreviousWin());
            record.setProducer(producerInterval.getProducer());
            minRange.add(record);
        });
    }

    public void updateMaxAwardsRange(List<ProducerAwardDTO> maxRange, AwardInterval awardInterval) {
        awardInterval.getMax().forEach(producerInterval -> {
            ProducerAwardDTO record = new ProducerAwardDTO();
            record.setFollowingWin(producerInterval.getFollowingWin());
            record.setInterval(producerInterval.getInterval());
            record.setPreviousWin(producerInterval.getPreviousWin());
            record.setProducer(producerInterval.getProducer());
            maxRange.add(record);
        });
    }

}
