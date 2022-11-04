package it.develhope.CRUD.entity;

import lombok.Data;

import javax.persistence.*;

@Table
@Entity
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String modelName;
    private String type;


}
