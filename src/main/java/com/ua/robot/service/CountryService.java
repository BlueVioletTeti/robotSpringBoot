package com.ua.robot.service;

import com.ua.robot.domain.City;
import com.ua.robot.domain.Country;
import com.ua.robot.dto.CountryDto;
import com.ua.robot.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    public List<CountryDto> findAll() {
        return countryRepository.findAll()
                .stream()
                .map(CountryService::buildCountryDto)
                .collect(Collectors.toList());
    }
//public List<CountryDto> add(){
//        return List.of(
//                new Country("Ukraine", "Kyiv", 43790, 603700, "Europe", "Temperate",)
////                new Country("Viki", 21, "Lviv"),
////                new Country("Jane", 19, "Odesa")
//        );
//    }


    private static CountryDto buildCountryDto(Country country) {
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getCountryName())
                .citiesName(country.getCities().stream()
                        .map(City::getCityName)
                        .collect(Collectors.toList()))
                .build();
    }
    public Optional<Country> findById(Long id){
        return countryRepository.findById(id);
    }

    public void save(Country country){
        countryRepository.save(country);
    }
}
