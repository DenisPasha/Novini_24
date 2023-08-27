package com.example.novini_24.model;

import java.util.List;

public class Articles {
    private List<ApiResponseDto> articles;

    public Articles() {
    }

    public Articles(List<ApiResponseDto> articles) {
        this.articles = articles;
    }

    public List<ApiResponseDto> getArticles() {
        return articles;
    }
}
