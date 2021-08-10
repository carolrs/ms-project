package com.devsuperior.hrworker.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_worker")
public class Worker implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String name;
    private Double dailyIncome;

    public Worker(){

    }

    public Worker(long id, String name, Double dailyIncome) {
        Id = id;
        this.name = name;
        this.dailyIncome = dailyIncome;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(Double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }
}

