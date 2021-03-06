package com.peregud.travelhistoryrest.domain;

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
    private String city;
    private Integer year;
    private String description;
    private String user;

    @Column(name = "current_weather")
    private CurrentWeather currentWeather;
}
