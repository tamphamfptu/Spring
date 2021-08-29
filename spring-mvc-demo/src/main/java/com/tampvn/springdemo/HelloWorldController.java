package com.tampvn.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
    //need a controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    //new a controller method to read form data and
    //add new data to the model
    @RequestMapping("/processFormV2")
    public String letShoutDude(HttpServletRequest request, Model model){
            //read the request parameter form the HTML form
            String theName = request.getParameter("studentName");

            //convert the data to all caps
            theName = theName.toUpperCase(Locale.ROOT);

            //create the message
            String msg = "Supp!! " + theName;

            //add message to the model
            model.addAttribute("message", msg);
            model.addAttribute("nameUpper",theName);
            return "helloworld";
    }
    @RequestMapping("/processFormV3")
    public String processFormV3(
            @RequestParam("studentName") String theName,
            Model model){

        //convert the data to all caps
        theName = theName.toUpperCase(Locale.ROOT);

        //create the message
        String msg = "Hey my friend from V3  " + theName;

        //add message to the model
        model.addAttribute("message", msg);
        model.addAttribute("nameUpper",theName);
        return "helloworld";
    }
}
