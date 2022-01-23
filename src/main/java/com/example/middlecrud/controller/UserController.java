package com.example.middlecrud.controller;


import com.example.middlecrud.entity.User;
import com.example.middlecrud.service.UserService;
import com.example.middlecrud.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model)
    {
        model.addAttribute("users",userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String getUserDetails(@PathVariable Long id, Model model)
    {
        model.addAttribute("user",userService.getUser(id));
        return "info";
    }

    @GetMapping("/add")
    public String getAddForm(@ModelAttribute ("user") User user)
    {
        return "add-user";
    }

    @PostMapping("/save")
    public String addUser(@ModelAttribute ("user") @Valid User user)
    {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id)
    {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String getUpdateUserForm(@PathVariable Long id,Model model)
    {
        model.addAttribute("user",userService.getUser(id));
        return "update-user";
    }

    @PutMapping("/update/{id}")
    public String getUpdateUserForm(@PathVariable Long id,User user)
    {
        userService.updateUser(user);
        return "redirect:/users";
    }

}
