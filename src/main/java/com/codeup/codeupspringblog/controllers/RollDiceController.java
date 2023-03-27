package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String RollDice(){
        return "diceroll";
    }

    @PostMapping("/roll-dice")
    public String RollResult(@RequestParam(name = "num") int num, Model model){
        model.addAttribute("guess",num);

        Random rand = new Random();
        int randomNumber = rand.nextInt(7);

        model.addAttribute("random",randomNumber);
        if (randomNumber == num){
            return "yay";
        }

        return "diceroll";
    }




    @GetMapping("/roll-dices")
    public String dice(){
        return "dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String diceResult(@PathVariable String n, Model model){
        model.addAttribute("number",n);

        Random rand = new Random();
        int randomNumber = rand.nextInt(7);
        model.addAttribute("random",randomNumber);

        return "roll-guess";
    }

}
