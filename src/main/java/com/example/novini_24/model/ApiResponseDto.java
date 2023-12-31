package com.example.novini_24.model;

import java.time.LocalDate;


public class ApiResponseDto {
   private String author;
   private String title;
   private String description;
   private String url;
   private String urlToImage;
   private LocalDate publishedAt;
   private String content;

    public ApiResponseDto() {
    }

    public ApiResponseDto(String author, String title, String description, String url, String urlToImage, LocalDate publishedAt, String content) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public void setPublishedAt(LocalDate publishedAt) {
        this.publishedAt = publishedAt;
    }

    public LocalDate getPublishedAt() {
        return publishedAt;
    }

    public String getUrlToImage() {
        return urlToImage;
    }


    public String getContent() {
        return content;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
   
}
