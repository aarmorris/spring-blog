package com.codeup.springblog.controllers;
// Second Step is to create a Controller
import com.codeup.springblog.models.Dies;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roll-dice")
public class rollDiceController {
    @GetMapping
    public String homePage(){
        return "rollDice";
    }

    @GetMapping("/{num}")
    public String rollDie(@PathVariable int num, Model model){
        Dies di = new Dies();
        model.addAttribute("numberChosen",num);
        model.addAttribute("randomNumber", di.randomNum());
        return "rollDice";
    }
}
