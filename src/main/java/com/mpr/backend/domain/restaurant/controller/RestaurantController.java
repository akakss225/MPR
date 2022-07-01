package com.mpr.backend.domain.restaurant.controller;


import com.mpr.backend.domain.restaurant.Restaurant;
import com.mpr.backend.domain.restaurant.dto.RestaurantDto;
import com.mpr.backend.domain.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping("/api/restaurant/{station}")
    @CrossOrigin
    public List<RestaurantDto> test(@PathVariable("station") String station) {
        List<Restaurant> restaurantList = restaurantService.findRestaurantByStation(station);
        return restaurantList.stream()
                .map(RestaurantDto::from)
                .collect(Collectors.toList());
    }
}