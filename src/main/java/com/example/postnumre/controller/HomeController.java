package com.example.postnumre.controller;


import com.example.postnumre.service.PostAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    private final PostAccessor accessor;

    public HomeController() {
        accessor = new PostAccessor();
    }

    @GetMapping("/")
    public String index() {
        return "/html/index";
    }



    @PostMapping("/city")
    public String cityResult(@RequestParam("post") int post, RedirectAttributes attributes) {
        String city = accessor.cityIndexer(post);
        attributes.addAttribute("post",post);
        attributes.addAttribute("city",city);

        return "redirect:/city";


    }


    @GetMapping("/city")
    public String cityResult(
        @RequestParam("post") int post,
        @RequestParam("city") String city,
        Model model) {

        model.addAttribute("post",post);
        model.addAttribute("city",city);
        return "/html/city.html";
    }


}
