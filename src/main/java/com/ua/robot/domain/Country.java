package com.ua.robot.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String countryName;
    @Column
    private String capital;
    @Column
    private int population;
    @Column
    private int area;
    @Column
    private String continent;
    @Column
    private String climate;
    @OneToMany(mappedBy = "country")
    private List<City> cities;
}
