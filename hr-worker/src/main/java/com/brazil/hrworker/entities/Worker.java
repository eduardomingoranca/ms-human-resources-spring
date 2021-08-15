package com.brazil.hrworker.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_worker")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Worker implements Serializable {

    /**
     * Serializable >> é para que class/objeto possa ser transformado em bytes
     * é importante para que o objeto passe na rede gravado como arquivo
     * */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double dailyIncome;

}
