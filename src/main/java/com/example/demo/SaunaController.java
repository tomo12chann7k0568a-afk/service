package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/sauna")
public class SaunaController {

    @GetMapping("/search")
    public String searchSauna(@RequestParam String keyword,
                              @RequestParam String area) {

        String apiKey = "AIzaSyCDhuXVccRxkWnK1rREJZYHyzeg4YxhO0w";

        String url = "https://maps.googleapis.com/maps/api/place/textsearch/json"
                + "?query=" + keyword + "+サウナ+" + area
                + "&language=ja"
                + "&key=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
