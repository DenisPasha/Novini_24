package com.example.novini_24.web.pagesController;

import com.example.novini_24.config.CurrentUser;
import com.example.novini_24.model.Articles;
import com.example.novini_24.service.ApiService;
import com.example.novini_24.service.UserService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    private final ApiService apiService;
    private final UserService userService;
    private final CurrentUser currentUser;

    public PagesController(ApiService apiService, UserService userService, CurrentUser currentUser) {
        this.apiService = apiService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    public String getHome1(Model model, OAuth2AuthenticationToken auth2AuthenticationToken){

        Articles topHeadlinesBg = apiService.getTopHeadlinesBg();

        model.addAttribute("topHeadlinesBg" , topHeadlinesBg);
        return "index";
    }
    @GetMapping("/currentUser")
    public String getLoggedInUser(Model model, OAuth2AuthenticationToken auth2AuthenticationToken){
        String registrationSource = auth2AuthenticationToken.getAuthorizedClientRegistrationId();

        userService.checkUser(auth2AuthenticationToken);
        return "redirect:/";
    }
    @GetMapping("/index")
    public String getHome(Model model){
        Articles topHeadlinesBg = apiService.getTopHeadlinesBg();

        model.addAttribute("topHeadlinesBg" , topHeadlinesBg);
        return "index";
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

    @GetMapping("/login")
    public String getLogin(Model model, OAuth2AuthenticationToken auth2AuthenticationToken){

        if (auth2AuthenticationToken != null){
            return "redirect:/";
        }


        return "login";
    }

}
