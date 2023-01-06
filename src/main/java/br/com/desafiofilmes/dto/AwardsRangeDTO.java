package br.com.desafiofilmes.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class AwardsRangeDTO implements Serializable {

    private List<ProducerAwardDTO> min;
    private List<ProducerAwardDTO> max;

    public List<ProducerAwardDTO> getMin() {
        if (min == null) {
            min = new ArrayList<>();
        }
        return min;
    }

    public List<ProducerAwardDTO> getMax() {
        if (max == null) {
            max = new ArrayList<>();
        }
        return max;
    }

}
