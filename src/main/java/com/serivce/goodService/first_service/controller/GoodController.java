package com.serivce.goodService.first_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.serivce.goodService.first_service.domain.entity.GoodEntity;
import com.serivce.goodService.first_service.service.GoodService;

@RestController
@RequestMapping("/first/service/")
@RequiredArgsConstructor
public class GoodController {

    private GoodService goodService;

    private GoodEntity goodEntity;

    @GetMapping("{id}")
    public String mockTest(@PathVariable("id") String id){
        return "result";
    }

    //Create
    @PostMapping("/service")
    public String create(){
        System.out.println("post service");
        return "Success";
    }


    //Read
    @GetMapping("/service")
    public String find(){
        System.out.println("Hi Get Method");
        return "Success";
    }


    //Update
    @PutMapping("/serivce")
    public String update(){
        System.out.println("hi put method");
        return "Success";
    }


    //Delete
    @DeleteMapping("/delete")
    public String delete(){
        return "Success";
    }


}
