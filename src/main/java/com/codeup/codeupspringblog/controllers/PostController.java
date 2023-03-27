package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String posts(Model model){
        List<Post> posts = new ArrayList<>(Arrays.asList(

                new Post("title","desc"),
                new Post("my life","boring")
        ));

        model.addAttribute("posts",posts);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")

    public String posts(@PathVariable int id, Model model){
        Post post = new Post("me","and ur mom");

        model.addAttribute("post",post);

        return "posts/show";

    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createForm(){
        return "<form method =\"POST\"><button>Submit</button></form>";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String create(){
        return "created new post";
    }
}
