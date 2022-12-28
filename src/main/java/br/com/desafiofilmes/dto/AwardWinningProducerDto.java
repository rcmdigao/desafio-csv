package br.com.desafiofilmes.dto;

import lombok.*;

@Data
@NoArgsConstructor
public class AwardWinningProducerDto {
	private String producer;
	private Integer interval;
	private Integer previousWin;
	private Integer followingWin;
}
