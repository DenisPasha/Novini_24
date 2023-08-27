package com.example.novini_24.service;

import com.example.novini_24.common.BgTopHeadlinesCategories;
import com.example.novini_24.common.WorldTopHeadlinesCategories;
import com.example.novini_24.model.ApiResponseDto;
import com.example.novini_24.model.Articles;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Service
public class ApiService {
    private final RestTemplate restTemplate;
    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Articles getTopHeadlinesBg(){

        ResponseEntity<Articles> responseEntity = restTemplate.getForEntity(BgTopHeadlinesCategories.TOP_HEADLINE_FROM_BG, Articles.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()){
            Articles body = responseEntity.getBody();

            convertDate(Objects.requireNonNull(body));
            return responseEntity.getBody();
        }

        throw new ResponseStatusException(HttpStatusCode.valueOf(responseEntity.getStatusCode().value()));
    }

    public Articles getEverythingFromBBC(){

        ResponseEntity<Articles> responseEntity = restTemplate.getForEntity(WorldTopHeadlinesCategories.EVERYTHING_FROM_BBC_NEWS, Articles.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()){

            Articles body = responseEntity.getBody();

            convertDate(Objects.requireNonNull(body));
           // checkImages(Objects.requireNonNull(body));
            return responseEntity.getBody();
        }
        throw new ResponseStatusException(HttpStatusCode.valueOf(responseEntity.getStatusCode().value()));
    }
    private void checkImages(Articles body) {

        for (ApiResponseDto article : body.getArticles()) {
            String urlToImage = article.getUrlToImage();

            ResponseEntity<String> responseEntity = restTemplate.exchange(
                    urlToImage,            // URL to check
                    HttpMethod.GET, // HTTP method
                    null,           // Request entity (headers, body, etc.)
                    String.class    // Response type
            );
            // TODO finish this thing with the images
            if (responseEntity.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                urlToImage = "img/default-news-img.jpg";
                article.setUrlToImage(urlToImage);
            }

        }



    }

    private void convertDate(Articles body) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        for (ApiResponseDto article : body.getArticles()) {
            LocalDate publishedAt = article.getPublishedAt();
            String format = publishedAt.format(formatter);
            LocalDate localDate = LocalDate.parse(format ,formatter);
            article.setPublishedAt(localDate);
        }
    }
}
