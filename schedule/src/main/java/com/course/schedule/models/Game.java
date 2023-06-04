package com.course.schedule.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Введіть, будь ласка, дату")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;

    @NotEmpty(message = "Введіть, будь ласка, учасників")
    private String players1;

    @NotEmpty(message = "Введіть, будь ласка, учасників")
    private String players2;

    public Game(LocalDateTime date, String players1, String players2) {
        this.date = date;
        this.players1 = players1;
        this.players2 = players2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPlayers1() {
        return players1;
    }

    public void setPlayers1(String players1) {
        this.players1 = players1;
    }

    public String getPlayers2() {
        return players2;
    }

    public void setPlayers2(String players2) {
        this.players2 = players2;
    }
}
