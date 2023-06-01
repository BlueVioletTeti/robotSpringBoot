package com.ua.robot.service;

import com.ua.robot.domain.City;
import com.ua.robot.dto.CityDto;
import com.ua.robot.repository.CityRepository;
import com.ua.robot.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    public List<CityDto> findAll(){
        return cityRepository.findAll().stream()
                .map(CityService::buildCityDto)
                .collect(Collectors.toList());

//        return List.of(
//                new Student("Ivan", 20, "Kyiv"),
//                new Student("Viki", 21, "Lviv"),
//                new Student("Jane", 19, "Odesa")
//        );
    }

    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }
    private static CityDto buildCityDto(City city) {
        var countryName = "NO COUNTRY";
        if (city.getCountry() != null) {
            countryName = city.getCountry().getCountryName();
        }
        return CityDto.builder()
                .id(city.getId())
                .name(city.getCityName())
                .population(city.getPopulation())
                .area(city.getArea())
                .name(countryName)
                .build();
    }

    public void save(City city){
        cityRepository.save(city);
    }

    public void addCountry(Long cityId, Long countryId) {
        var country = countryRepository.findById(countryId).get();
        var city = cityRepository.findById(cityId).get();
        city.setCountry(country);

        cityRepository.save(city);
    }
}
