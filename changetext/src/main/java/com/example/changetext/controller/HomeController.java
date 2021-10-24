package com.example.changetext.controller;

import com.example.changetext.model.TextArea;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
public class HomeController {

    @GetMapping({"/"} )
    public String getHome( Model model) {
        model.addAttribute("TextArea",new TextArea());
        return "index";
    }

    @PostMapping({"/"} )
    public String postHome(@RequestParam("submit") String buttonName, @ModelAttribute("TextArea") TextArea text, Model model) {

       if(buttonName.equals("Lower")) {
           model.addAttribute("TextArea",new TextArea(text.getName().toLowerCase()));
       }
       else if(buttonName.equals("Upper")){
           model.addAttribute("TextArea",new TextArea(text.getName().toUpperCase()));
       }
       else if(buttonName.equals("Sentence")){
           String s="";
           String[] split  = text.getName().trim().split("\\.");

        for(int i=0;i<split.length; i++){

             s = s+ split[i].trim().substring(0, 1).toUpperCase() + split[i].trim().substring(1).toLowerCase() + ". " ;
              }
        model.addAttribute("TextArea",new TextArea(s));
       }

        return "index";
    }


    @GetMapping({"/lower"} )
    public String getLower( Model model) {
        model.addAttribute("TextArea",new TextArea());
        return "lower";
    }

    @PostMapping({"/lower"} )
    public String postLower(@ModelAttribute("TextArea") TextArea text, Model model) {
        model.addAttribute("TextArea",new TextArea(text.getName().toLowerCase()));
        return "lower";
    }


    @GetMapping({"/upper"} )
    public String getUpper( Model model) {
        model.addAttribute("TextArea",new TextArea());
        return "upper";
    }

    @PostMapping({"/upper"} )
    public String postUpper(@ModelAttribute("TextArea") TextArea text, Model model) {
        model.addAttribute("TextArea",new TextArea(text.getName().toUpperCase()));
        return "upper";
    }




}
