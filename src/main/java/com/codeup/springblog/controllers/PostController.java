package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.Users;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.Utils;
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


    //    Takes me to the create.html which is main page that says Create your post
    @GetMapping("posts/create")
    public String homepageBlog(Model model){
        List<Users> users = userDao.findAll();
        model.addAttribute("users", users);
        model.addAttribute("post", new Post());
        return "posts/show";
    }


    // This lets you add a post i refactor it to form model binding also the html
    @PostMapping("/posts/show")
    public String addPostWithUser(@ModelAttribute Post post){
        Users user = Utils.currentUser();
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts/index";
    }

}