package com.example.novini_24.common;

public enum WorldTopHeadlinesCategories {
    ;
    private static final String API_KEY = "d683292684f54234be0ff4bef37df89f";
    public static final String EVERYTHING_FROM_BBC_NEWS = String.format("https://newsapi.org/v2/everything?q=bbc.co.uk&apiKey=%s",API_KEY);
}
