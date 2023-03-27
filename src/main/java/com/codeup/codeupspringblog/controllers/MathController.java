package com.codeup.codeupspringblog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String returnSum(@PathVariable int num1, @PathVariable int num2){
        return " ur total is" +  num1 + num2 ;
    }

    @GetMapping("/subtract/{num1}/and/{num2}")
    @ResponseBody
    public String returnSubtracted(@PathVariable int num1,@PathVariable int num2){
        return " ur total is" +  (num1 - num2) ;
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String returnMultiplied(@PathVariable int num1,@PathVariable int num2){
        return " ur total is" +  (num1 * num2) ;
    }

    @GetMapping("/divide/{num1}/and/{num2}")
    @ResponseBody
    public String returnDivide(@PathVariable int num1,@PathVariable int num2){
        return " ur total is" +  (num1 / num2) ;
    }
}
