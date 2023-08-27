package com.example.novini_24.service;

import com.example.novini_24.common.BgTopHeadlinesCategories;
import com.example.novini_24.model.ApiResponseDto;
import com.example.novini_24.model.Articles;
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
