package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String postIndex() {
        return "posts index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String individualPost(@PathVariable long id){
        return "view an individual post " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String creatingPost(){
        return "<h1>Testing Post Map</h1>\n" +
                "    <form method=\"post\" action=\"/posts/create\">\n" +
                "        <label for=\"word\">Press button to Test!:</label>\n" +
                "        <input type=\"text\" name=\"word\" id=\"word\">\n" +
                "        <button type=\"submit\">Testing PostMapping</button>\n" +
                "    </form>";
}
    @PostMapping("/posts/create")
    @ResponseBody
    public String newPost(){
        return "create a new post";
        }

}