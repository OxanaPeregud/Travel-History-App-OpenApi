package com.peregud.travelhistory.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "journey")
public class Journey implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;

    @Column(name = "current_weather")
    private String currentWeather;
    private Integer year;
    private String description;
    private String user;
}
