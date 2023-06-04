package com.course.schedule.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Будь ласка, введіть назву змагань")
    private String title;

    @NotEmpty(message = "Будь ласка, введіть місце проведення змагань")
    private String place;

    @Min(value = 0, message = "Рахунок не може бути менше 0!")
    private Integer result1;

    @Min(value = 0, message = "Рахунок не може бути менше 0!")
    private Integer result2;

    @NotEmpty(message = "Будь ласка, введіть назву першої команди")
    private String team1;

    @NotEmpty(message = "Будь ласка, введіть назву другої команди")
    private String team2;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    private Results result;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    private Game game;

    public Schedule(String title, String place, String team1, String team2, Results result, Game game) {
        this.title = title;
        this.place = place;
        this.game = game;
        this.team1 = team1;
        this.team2 = team2;
        this.result = result;
    }
}