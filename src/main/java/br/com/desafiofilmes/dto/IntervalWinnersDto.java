package br.com.desafiofilmes.dto;

import java.util.List;

public class IntervalWinnersDto {
	
	private List<AwardWinningProducerDto> min;
	private List<AwardWinningProducerDto> max;
	
	public List<AwardWinningProducerDto> getMin() {
		return min;
	}
	public void setMin(List<AwardWinningProducerDto> min) {
		this.min = min;
	}
	public List<AwardWinningProducerDto> getMax() {
		return max;
	}
	public void setMax(List<AwardWinningProducerDto> max) {
		this.max = max;
	}
	
}
