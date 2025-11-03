package com.souvik.nestleapapplication.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // This shows your static index.html page
        return "forward:/index.html";
    }

    @GetMapping("/about")
    public String about() {
        return "forward:/about.html";
    }

    @GetMapping("/contact")
    public String contact() {
        return "forward:/contact.html";
    }

    @GetMapping("/privacy")
    public String privacy() {
        return "forward:/privacy.html";
    }

    @GetMapping("/propertyDetails")
    public String propertyDetails() {
        return "forward:/propertyDetails.html";
    }

    @GetMapping("/signin")
    public String signin() {
        return "forward:/signin.html";
    }

    @GetMapping("/login")
    public String login() {
        return "forward:/signin.html"; // Both login & signin go to same page
    }

}
