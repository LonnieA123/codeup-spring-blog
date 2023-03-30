package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.CommentRepository;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PostController {


    PostRepository postDao;
    UserRepository userDao;
    CommentRepository commentDao;

    public PostController(PostRepository postDao, UserRepository userDao, CommentRepository commentDao) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.commentDao = commentDao;
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








    @GetMapping("/posts/create")
    public String createForm(){
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@RequestParam (name="title") String title,
                         @RequestParam (name="body") String body){
        User user = userDao.findById(1L).get();
        Post post = new Post(title,body,user);

        postDao.save(post);

        return "redirect:/posts";
    }

}
