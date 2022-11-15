package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{sum}/and/{sum2}")
    @ResponseBody
    public int addInt(@PathVariable int sum, @PathVariable int sum2){
        return sum + sum2;
    }

    @GetMapping("/subtract/{sub}/and/{sub2}")
    @ResponseBody
    public int subInt(@PathVariable int sub, @PathVariable int sub2){
        return sub - sub2;
    }

    @GetMapping("/multiply/{multi}/and/{multi2}")
    @ResponseBody
    public int multiplayInt(@PathVariable int multi, @PathVariable int multi2){
        return multi * multi;
    }
}
