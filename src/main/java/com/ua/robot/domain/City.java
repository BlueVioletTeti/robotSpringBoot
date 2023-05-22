package com.ua.robot.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cityName;
    @Column
    private int population;
    @Column
    private int area;
@ManyToOne
@JoinColumn(name = "country_id")
    private Country country;
}
