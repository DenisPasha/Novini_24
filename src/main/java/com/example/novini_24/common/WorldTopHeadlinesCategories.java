package com.example.novini_24.common;

public enum WorldTopHeadlinesCategories {
    ;
    private static final String API_KEY = "d683292684f54234be0ff4bef37df89f";
    public static final String EVERYTHING_FROM_BBC_NEWS = String.format("https://newsapi.org/v2/everything?q=bbc.co.uk&apiKey=%s",API_KEY);
    public static final String BUSINESS_FROM_WORLD = String.format("https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=%s",API_KEY);
    public static final String SPORT_FROM_WORLD = String.format("https://newsapi.org/v2/top-headlines?country=us&category=sport&apiKey=%s",API_KEY);
    public static final String TECHNOLOGY_FROM_WORLD = String.format("https://newsapi.org/v2/top-headlines?country=us&category=technology&apiKey=%s",API_KEY);
    public static final String ENTERTAINMENT_FROM_WORLD = String.format("https://newsapi.org/v2/top-headlines?country=us&category=entertainment&apiKey=%s",API_KEY);
    public static final String HEALTH_FROM_WORLD = String.format("https://newsapi.org/v2/top-headlines?country=us&category=health&apiKey=%s",API_KEY);
    public static final String SCIENCE_FROM_WORLD = String.format("https://newsapi.org/v2/top-headlines?country=us&science=health&apiKey=%s",API_KEY);
}
