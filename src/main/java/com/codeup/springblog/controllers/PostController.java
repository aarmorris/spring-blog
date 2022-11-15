package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String individualPost(){
        return "view an individual post";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String creatingPost(){
        return "<h1>spring-blog post form</h1>\n" +
                "    <form method=\"post\" action=\"/posts/create\">\n" +
                "        <label for=\"word\">Enter a word:</label>\n" +
                "        <input type=\"text\" name=\"word\" id=\"word\">\n" +
                "        <button type=\"submit\">Submit</button>\n" +
                "    </form>";
}
    @PostMapping("/posts/create")
    @ResponseBody
    public String newPost(){
        return "create a new post";
        }

}