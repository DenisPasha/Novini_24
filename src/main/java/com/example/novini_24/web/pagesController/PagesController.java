package com.example.novini_24.web.pagesController;

import com.example.novini_24.model.ApiResponseDto;
import com.example.novini_24.model.Articles;
import com.example.novini_24.service.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    private final ApiService apiService;

    public PagesController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/index")
    public String getHome(Model model){
        Articles topHeadlinesBg = apiService.getTopHeadlinesBg();

        model.addAttribute("topHeadlinesBg" , topHeadlinesBg);
        return "index";
    }

    @GetMapping("/index-world")
    public String getWorld(Model model){

        Articles everythingFromBBC = apiService.getEverythingFromBBC();
        model.addAttribute("everythingFromBBC" , everythingFromBBC);
        return "index-world";
    }

    @GetMapping("/category")
    public String getCategory(Model model){
        return "category";
    }

    @GetMapping("/singleNews")
    public String getSingle(Model model){
        return "single";
    }
    @GetMapping("/contact")
    public String getContact(Model model){
        return "contact";
    }

}
