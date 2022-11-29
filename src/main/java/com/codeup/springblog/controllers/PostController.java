package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.Users;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {



    @GetMapping("/posts")
    public String postIndex(Model model) {
        List<Post> allPost = postDao.findAll();
        model.addAttribute("allPost", allPost);
        return "/posts/index";
    }

    private final PostRepository postDao;

    private  final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
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
       postDao.save(post);
        return "redirect:/posts/";
        }

    @GetMapping("/posts/users")
    public String usersHome(Model model){
        model.addAttribute("user",new Users());
        return "/posts/Users";
    }


    @PostMapping("/posts/users")
    public String insertUser(@ModelAttribute Users user) {
        userDao.save(user);
        return "redirect:/posts/users";
    }
}