package com.example.novini_24.service;

import com.example.novini_24.common.BgTopHeadlinesCategories;
import com.example.novini_24.common.WorldTopHeadlinesCategories;
import com.example.novini_24.model.ApiResponseDto;
import com.example.novini_24.model.Articles;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

        ResponseEntity<Articles> responseEntity = restTemplate
                .getForEntity(WorldTopHeadlinesCategories.EVERYTHING_FROM_BBC_NEWS, Articles.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()){

            Articles body = responseEntity.getBody();

            convertDate(Objects.requireNonNull(body));
           // checkImages(Objects.requireNonNull(body),responseEntity);
            return responseEntity.getBody();
        }
        throw new ResponseStatusException(HttpStatusCode.valueOf(responseEntity.getStatusCode().value()));
    }

    @Cacheable("businessCategoryWorld")
    public Articles getBusinessCategoryWorld(){
        ResponseEntity<Articles> responseEntity = restTemplate
                .getForEntity(WorldTopHeadlinesCategories.BUSINESS_FROM_WORLD, Articles.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()){
            Articles body = responseEntity.getBody();
            convertDate(Objects.requireNonNull(body));
            return responseEntity.getBody();
        }
        throw new ResponseStatusException(HttpStatusCode.valueOf(responseEntity.getStatusCode().value()));
    }

    @Cacheable("sportCategoryWorld")
    public Articles getSportCategoryWorld(){
        ResponseEntity<Articles> responseEntity = restTemplate
                .getForEntity(WorldTopHeadlinesCategories.SPORT_FROM_WORLD, Articles.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()){
            Articles body = responseEntity.getBody();
            convertDate(Objects.requireNonNull(body));
            return responseEntity.getBody();
        }
        throw new ResponseStatusException(HttpStatusCode.valueOf(responseEntity.getStatusCode().value()));
    }

    @Cacheable("technologyCategoryWorld")
    public Articles getTechnologyCategoryWorld(){
        ResponseEntity<Articles> responseEntity = restTemplate
                .getForEntity(WorldTopHeadlinesCategories.TECHNOLOGY_FROM_WORLD, Articles.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()){
            Articles body = responseEntity.getBody();
            convertDate(Objects.requireNonNull(body));
            return responseEntity.getBody();
        }
        throw new ResponseStatusException(HttpStatusCode.valueOf(responseEntity.getStatusCode().value()));
    }

    @Cacheable("entertainmentCategoryWorld")
    public Articles getEntertainmentCategoryWorld(){
        ResponseEntity<Articles> responseEntity = restTemplate
                .getForEntity(WorldTopHeadlinesCategories.ENTERTAINMENT_FROM_WORLD, Articles.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()){
            Articles body = responseEntity.getBody();
            convertDate(Objects.requireNonNull(body));
            return responseEntity.getBody();
        }
        throw new ResponseStatusException(HttpStatusCode.valueOf(responseEntity.getStatusCode().value()));
    }

    @Cacheable("healthCategoryWorld")
    public Articles getHealthCategoryWorld(){
        ResponseEntity<Articles> responseEntity = restTemplate
                .getForEntity(WorldTopHeadlinesCategories.HEALTH_FROM_WORLD, Articles.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()){
            Articles body = responseEntity.getBody();
            convertDate(Objects.requireNonNull(body));
            return responseEntity.getBody();
        }
        throw new ResponseStatusException(HttpStatusCode.valueOf(responseEntity.getStatusCode().value()));
    }
    @Cacheable("scienceCategoryWorld")
    public Articles getScienceCategoryWorld(){
        ResponseEntity<Articles> responseEntity = restTemplate
                .getForEntity(WorldTopHeadlinesCategories.SCIENCE_FROM_WORLD, Articles.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()){
            Articles body = responseEntity.getBody();
            convertDate(Objects.requireNonNull(body));
            return responseEntity.getBody();
        }
        throw new ResponseStatusException(HttpStatusCode.valueOf(responseEntity.getStatusCode().value()));
    }
    private void checkImages(Articles body, ResponseEntity<Articles> responseEntity) {

        for (ApiResponseDto article : body.getArticles()) {
            String urlToImage = article.getUrlToImage();

            for ( ApiResponseDto response :body.getArticles()) {
                try {
                    ResponseEntity<?> res = restTemplate.getForEntity(urlToImage, byte[].class);
                }catch (RestClientException e ){
                    urlToImage = "img/default-news-img.jpg";
                    article.setUrlToImage(urlToImage);
                }
            }

        }
    }



    private void convertDate(Articles body) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        for (ApiResponseDto article : body.getArticles()) {
            LocalDate publishedAt = article.getPublishedAt();
            if (publishedAt!=null){
                String format = publishedAt.format(formatter);
                LocalDate localDate = LocalDate.parse(format ,formatter);
                article.setPublishedAt(localDate);
            }

        }
    }


    public Articles checkImg(Articles everythingFromBBC) {
        List<ApiResponseDto> filteredArticles = new ArrayList<>();

        for (ApiResponseDto article : everythingFromBBC.getArticles()) {
            if (!article.getUrlToImage().contains("webp")) {
                filteredArticles.add(article);
            }
        }

        everythingFromBBC.getArticles().removeAll(everythingFromBBC.getArticles());
        everythingFromBBC.getArticles().addAll(filteredArticles);
        Articles fileteredByImgAndTitle = checkTitle(everythingFromBBC);
        return fileteredByImgAndTitle;
    }

    public Articles checkTitle(Articles everythingFromBBC) {
        List<ApiResponseDto> filteredArticles = new ArrayList<>();

        for (ApiResponseDto article : everythingFromBBC.getArticles()) {
            if (article.getTitle() != null) {
                filteredArticles.add(article);
            }
        }

        everythingFromBBC.getArticles().removeAll(everythingFromBBC.getArticles());
        everythingFromBBC.getArticles().addAll(filteredArticles);
        return everythingFromBBC;
    }


    public Articles getSingleNewsForCategory(String category) {
        Articles articles = null;
        switch (category){
            case "sport":
                articles = this.getSportCategoryWorld();
                break;
            case "business":
                articles = this.getBusinessCategoryWorld();
                break;
            case "technology":
                articles = this.getTechnologyCategoryWorld();
                break;
            case "entertainment":
                articles = this.getEntertainmentCategoryWorld();
                break;
            case "health":
                articles = this.getHealthCategoryWorld();
                break;
            case "science":
                articles = this.getScienceCategoryWorld();
                break;
        }
        return articles;
    }
}
