package se.ec.johan.springmvcassignments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Home {

    List<String> names = new ArrayList<>();

    @GetMapping("/index")
    public String index(){

        return "index";
    }

    @GetMapping("/contact")
    public String contact(){

        return "contact";
    }

    @PostMapping("/contact")
    public String contact(@RequestParam(value = "name") String input){
        if (!input.isEmpty()){
            names.add(input);
        }
        return "redirect:/contact";
    }

    @GetMapping("/contact-list")
    public String contactList(Model model){
        model.addAttribute("nameInput", names);
        return "contact-view";

    }

    @GetMapping("/about")
    public String about(Model model){
        String path = "/img/20180211_103616.jpg";
        model.addAttribute("img", path);
        return "about";
    }

}
