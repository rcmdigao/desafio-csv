package br.com.desafiofilmes.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProducerAwardDTO  implements Serializable {

    private String producer;
    private Long interval;
    private Long previousWin;
    private Long followingWin;

}