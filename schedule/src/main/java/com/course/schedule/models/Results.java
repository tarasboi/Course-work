package com.course.schedule.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@NoArgsConstructor
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Min(value = 0, message = "Рахунок не може бути менше 0!")
    private Integer result1;

    @Min(value = 0, message = "Рахунок не може бути менше 0!")
    private Integer result2;

    public Results(Integer result1, Integer result2) {
        this.result1 = result1;
        this.result2 = result2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getResult1() {
        return result1;
    }

    public void setResult1(Integer result1) {
        this.result1 = result1;
    }

    public Integer getResult2() {
        return result2;
    }

    public void setResult2(Integer result2) {
        this.result2 = result2;
    }
}