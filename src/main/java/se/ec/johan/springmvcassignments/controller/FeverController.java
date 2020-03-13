package se.ec.johan.springmvcassignments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FeverController {

    Double temp = 0.0;
    List<String> tempList = new ArrayList<>();

    @GetMapping("/fever-input")
    public String fever(Model model){
        model.addAttribute("tempList", tempList);
        return "fever-input";
    }


    @PostMapping("/fever-input")
    public String fever(@RequestParam(value = "fever", defaultValue = "0.0") Double fever, Model model) {

        temp = fever;
        tempList.add("Temperatur: " + String.valueOf(temp) + "°C");

        if (temp == 0.0){
            return "fever-input";
        }
        if (temp < 36) {
            model.addAttribute("temperature", "Din temperatur är: " + temp + "°C. Du måste få upp värmen lite...");
            return "low-temp";
        }
        if (temp >= 36 && temp < 37.6) {
            model.addAttribute("temperature", "Din temperatur är: " + temp + "°C. Detta är helt normalt min vän.");
            return "normal-temp";
        }
        if (temp > 37.7) {
            model.addAttribute("temperature", "Din temperatur är: " + temp + "°C. Du har CORONA!");
            return "high-temp";
        }
        return "redirect:/fever-input";

    }
}
