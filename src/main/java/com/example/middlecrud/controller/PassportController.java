package com.example.middlecrud.controller;


import com.example.middlecrud.entity.Passport;
import com.example.middlecrud.entity.User;
import com.example.middlecrud.service.passport.PassportServiceImpl;
import com.example.middlecrud.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PassportController {

    private final UserServiceImpl userService;

    private final PassportServiceImpl passportService;

    @Autowired
    public PassportController(UserServiceImpl userService, PassportServiceImpl passportService) {
        this.userService = userService;
        this.passportService = passportService;
    }

    @GetMapping("/users/{id}/addPass")
    public String getPassportAddForm(@PathVariable("id") Long id, @ModelAttribute("passport") Passport passport, Model model) {
        model.addAttribute("user",userService.getUser(id));
        return "passports/add-passport";
    }

    @PostMapping("/users/{id}/savePass")
    public String addPassport(@PathVariable("id") Long id, @Valid Passport passport, BindingResult result, Model model) {
        model.addAttribute("user",userService.getUser(id));
        if (result.hasErrors()) {
            return "passports/add-passport";
        }
        passport.setUser(userService.getUser(id));
        passportService.savePassport(passport);
        return "redirect:/users/" + id;
    }

    @GetMapping("/users/{id}/deletePass/{pass_id}")
    public String deletePassport(@PathVariable("id") Long id,@PathVariable("pass_id") Long pass_id) {
        passportService.deletePassport(pass_id);
        return "redirect:/users/" + id;
    }


    @GetMapping("/users/{id}/editPass/{pass_id}")
    public String getUpdatePassportForm(@PathVariable("id") Long id, @PathVariable("pass_id") Long pass_id, Model model) {
        Passport passport = passportService.getPassport(pass_id);
        User user = userService.getUser(id);
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("passport", passport);
        model.addAllAttributes(map);
        return "passports/update-passport";
    }

    @PutMapping("/users/{id}/updatePass/{pass_id}")
    public String updatePassport(@PathVariable("id") Long id, @Valid Passport passport, BindingResult result, @PathVariable("pass_id") Long pass_id, Model model) {
        User user = userService.getUser(id);
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("passport", passport);
        model.addAllAttributes(map);
        if (result.hasErrors()) {
            passport.setId(pass_id);
            return "passports/update-passport";
        }
        passportService.updatePassport(passport);
        return "redirect:/users/" + id;
    }






}
