package br.com.desafiofilmes.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProducerInterval implements Serializable {

    private String producer;
    private Long interval;
    private Long previousWin;
    private Long followingWin;

}
