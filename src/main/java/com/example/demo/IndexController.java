package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping(value = "/index")
public class IndexController {


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return "Hello Spinrg Boot";
    }
    
    @RequestMapping(value = "/helloJsp", method = RequestMethod.GET)
    public ModelAndView helloJsp(){
    	ModelAndView model = new ModelAndView();
    	model.setViewName("hello");
    	return model;
    }

    @RequestMapping(path = "/Hellojava")
    public String test() {
        return say() + say();
    }

    @RequestMapping(path = {"getId/{id}"})
    public int getid(@PathVariable("id") int id) {
        return id;
    }

    @RequestMapping(path = {"getString/{String}"})
    public String getSrting(@PathVariable("String") String string) {
        return string;
    }

    @RequestMapping(value = "/home/page")
    @ResponseBody
    public ModelAndView gohome() {
        System.out.println("go to the home page!");
        ModelAndView mode = new ModelAndView();
        mode.addObject("name", "YangJiYuan");
        mode.addObject("sex", "boy");
        mode.addObject("age", this.getid(24));
        mode.addObject("buttonName", "按钮");
        mode.setViewName("index");
        return mode;
    }

}