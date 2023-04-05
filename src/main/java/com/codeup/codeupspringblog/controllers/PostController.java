package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.Services.EmailService;
import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PostController {
    PostRepository postDao;
    UserRepository userDao;
    EmailService emailService;


    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }


    @GetMapping("/posts")
    public String posts(Model model){
        List<Post> posts = postDao.findAll();
        model.addAttribute("posts",posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String posts(@PathVariable long id, Model model){

        Optional<Post> optionalPost = postDao.findById(id);
        if (optionalPost.isPresent()){
            Post post = postDao.findById(id).get();
            model.addAttribute("post",post);
            model.addAttribute("user",post.getUser());

            return "/posts/show";
        }
        return "/posts";
    }


    @GetMapping("/posts/{id}/edit")
    public String editForm(@PathVariable long id, Model model){
        Post post = postDao.findById(id).get();
        model.addAttribute("post",post);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute Post post){
         postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/delete")
    public String deleteButton(@PathVariable long id){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post post = postDao.findById(id).get();

        if (post.getUser().getUsername().equals(user.getUsername())){
            postDao.deleteById(id);
        }
        return "redirect:/posts";
    }




    @GetMapping("/posts/create")
    public String createForm(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(user != null){
            model.addAttribute("post",new Post());
            return "/posts/create";
        }
        return "redirect:/login";

    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post postToSave = new Post(post.getTitle(),post.getBody(),user);
        postDao.save(postToSave);

//        emailService.prepareAndSend(post,"test","plz work");
        return "redirect:/posts";
    }

}
