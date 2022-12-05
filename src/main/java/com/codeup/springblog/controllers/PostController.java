package com.codeup.springblog.controllers;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.Users;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import com.codeup.springblog.services.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {



    @GetMapping("/posts")
    public String postLanding(Model model) {
        List<Post> allPost = postDao.findAll();
        model.addAttribute("allPost", allPost);
        return "/posts/landingpage";
    }

    @GetMapping("/posts/")
    public String userLanding(Model model) {
        List<Post> allPost = postDao.findAll();
        model.addAttribute("allPost", allPost);
        return "/posts/index";
    }

    private final PostRepository postDao;

    private  final UserRepository userDao;

    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable long id, Model model) {
        String testText = "The test passed";
        model.addAttribute("aPassedTest", testText);
        return "create";
    }


    //    Takes me to the create.html which is main page that says Create your post
    @GetMapping("/posts/create")
    public String createPostsForm(Model model){
        model.addAttribute("post", new Post());
        List<Users> users = userDao.findAll();
//        model.addAttribute("users", users);
        return "/posts/create";
    }


    // This lets you add a post i refactor it to form model binding also the html
    @PostMapping("/posts/create")
    public String postForm(@ModelAttribute Post post){
        Users user = Utils.currentUser();
        long userId = user.getId();
        user = userDao.findById(userId);
        post.setUser(user);
        postDao.save(post);
        emailService.prepareAndSend(user, post.getTitle(), post.getBody());
        return "redirect:/posts/";
    }
    @GetMapping("/posts/{id}/edit")
    public String editPostId(@PathVariable long id, Model model){
        Post post = postDao.findById(id);
        model.addAttribute("postEdit", post);

        long currentUserId = Utils.currentUser().getId();

        if (currentUserId == 0){
            return "redirect:/login";
        }
//        Post post1 = postDao.findById(id);
        if (post.getUser().getId() != currentUserId){
            return "redirect:/posts/";
        }
        model.addAttribute("post", post);
        return "/posts/edit";
    }



    @PostMapping("/posts/{id}/edit")
    public String editPostIdForm(@ModelAttribute Post editPost){



        List<Users> userList = userDao.findAll();
        postDao.save(editPost);
        return "redirect:/posts/";
    }

}