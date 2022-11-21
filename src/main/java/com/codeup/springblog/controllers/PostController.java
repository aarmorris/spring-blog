package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDAO;

    public PostController(PostRepository postDAO) {
        this.postDAO = postDAO;
    }

    @GetMapping("/posts")
    public String postIndex(Model model) {
        List<Post> allPost = postDAO.findAll();
        model.addAttribute("allPost", allPost);
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")

    public String individualPost(@PathVariable long id, Model model) {
        String testText = "The test passed";
        model.addAttribute("aPassedTest", testText);
        return "posts/show";
    }

    @GetMapping("/posts/create")
//    @ResponseBody
    public String creatingPost(){
        return "/posts/show";
}
    @PostMapping("/posts/create")
//    @ResponseBody
    public String newPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
       Post post = new Post(title,body);
       postDAO.save(post);
        return "redirect:/posts";
        }

}