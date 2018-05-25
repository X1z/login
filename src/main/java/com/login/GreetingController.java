package com.login;
import com.login.domain.Message;
import com.login.domain.User;
import com.login.resp.MessageRepo;
import com.login.resp.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private UserRepo userRepo;


    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Model model
    ) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String,Object> model){

        Iterable<Message> messages = messageRepo.findAll();
        for (Message message : messages) {
            System.out.println(message.getId());
        }
        model.put("messages",messages);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String,Object> model){

        Message message = new Message(text, tag);
        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages",messages);

        return "main";
    }


    @GetMapping("/register")
    public String register(Map<String,Object> model){

        return "register";

    }


    @PostMapping("/register")
    public String register(@RequestParam String login, @RequestParam String password, @RequestParam String name, @RequestParam String email, Map<String,Object> model){

        User user = new User(name, login, password, email);
        userRepo.save(user);


        return "register";
    }

    @PostMapping("/register1")
    public String register1(@RequestParam String login, @RequestParam String password1, @RequestParam String name, @RequestParam String email, Map<String,Object> model){

        User user = new User(name, login, password1, email);
        userRepo.save(user);


        return "register";
    }

    @PostMapping("/allusers")
    public String allusers(Map<String,Object> model){

        Iterable<User> users = userRepo.findAll();
        model.put("users",users);

        return "allusers";
    }


}