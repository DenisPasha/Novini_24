package com.example.novini_24.common;

public enum BgTopHeadlinesCategories {
    ;
    private static final String API_KEY = "d683292684f54234be0ff4bef37df89f";
    public static final String TOP_HEADLINE_FROM_BG = String.format("https://newsapi.org/v2/top-headlines?country=bg&apiKey=%s",API_KEY);
    public static final String TOP_HEADLINE_FROM_BG_BUSINESS =String.format( "https://newsapi.org/v2/top-headlines?country=bg&category=business&apiKey=%s",API_KEY);
    public static final String TOP_HEADLINE_FROM_BG_SPORT = String.format( "https://newsapi.org/v2/top-headlines?country=bg&category=sport&apiKey=%s",API_KEY);
    public static final String TOP_HEADLINE_FROM_BG_ENTERTAINMENT = String.format( "https://newsapi.org/v2/top-headlines?country=bg&category=entertainment&apiKey=%s",API_KEY);
    public static final String TOP_HEADLINE_FROM_BG_TECHNOLOGY = String.format( "https://newsapi.org/v2/top-headlines?country=bg&category=technology&apiKey=%s",API_KEY);
    public static final String TOP_HEADLINE_FROM_BG_HEALTH = String.format( "https://newsapi.org/v2/top-headlines?country=bg&category=health&apiKey=%s",API_KEY);
    public static final String TOP_HEADLINE_FROM_BG_SCIENCE = String.format("https://newsapi.org/v2/top-headlines?country=bg&category=science&apiKey=%s",API_KEY);
    public static final String TOP_HEADLINE_FROM_BG_GENERAL = String.format("https://newsapi.org/v2/top-headlines?country=bg&category=general&apiKey=%s",API_KEY);
}
