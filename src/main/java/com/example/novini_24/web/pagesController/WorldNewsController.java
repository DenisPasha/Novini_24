package com.example.novini_24.web.pagesController;

import com.example.novini_24.model.ApiResponseDto;
import com.example.novini_24.model.Articles;
import com.example.novini_24.service.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
public class WorldNewsController {

    private final ApiService apiService;

    public WorldNewsController(ApiService apiService) {
        this.apiService = apiService;
    }
    @GetMapping("/index-world")
    public String getHome(Model model){
        Articles everythingFromBBC = apiService.getEverythingFromBBC();

        Articles articles = apiService.checkImg(everythingFromBBC);
        model.addAttribute("everythingFromBBC" , articles);
        return "index-world";
    }

    @GetMapping("/bussines-world")
    public String getBusiness(Model model){
        Articles businessCategoryWorld = apiService.getBusinessCategoryWorld();

        Articles filtered = apiService.checkTitle(businessCategoryWorld);
        model.addAttribute("categoryNews", filtered);
        model.addAttribute("category" , "Category: Business");
        return "category";
    }
    @GetMapping("/sport-world")
    public String getSport(Model model){
        Articles businessCategoryWorld = apiService.getSportCategoryWorld();

        Articles filtered = apiService.checkTitle(businessCategoryWorld);
        model.addAttribute("categoryNews", filtered);
        model.addAttribute("category" , "Category: Sport");
        return "category";
    }

    @GetMapping("/entertainment-world")
    public String getEntertainment(Model model){
        Articles businessCategoryWorld = apiService.getEntertainmentCategoryWorld();

        Articles filtered = apiService.checkTitle(businessCategoryWorld);
        model.addAttribute("categoryNews", filtered);
        model.addAttribute("category" , "Category: Entertainment");
        return "category";
    }

    @GetMapping("/technology-world")
    public String getTechnology(Model model){
        Articles businessCategoryWorld = apiService.getTechnologyCategoryWorld();
        Articles filtered = apiService.checkTitle(businessCategoryWorld);

        model.addAttribute("categoryNews", filtered);
        model.addAttribute("category" , "Category: Technology");
        return "category";
    }

    @GetMapping("/health-world")
    public String getHealth(Model model){
        Articles businessCategoryWorld = apiService.getHealthCategoryWorld();

        Articles filtered = apiService.checkTitle(businessCategoryWorld);
        model.addAttribute("categoryNews", filtered);
        model.addAttribute("category" , "Category: Health");
        return "category";
    }
    @GetMapping("/science-world")
    public String getScience(Model model){
        Articles categoryInfo = apiService.getScienceCategoryWorld();

        Articles filtered = apiService.checkTitle(categoryInfo);
        model.addAttribute("categoryNews", filtered);
        model.addAttribute("category" , "Category: Science");
        return "category";
    }



}
