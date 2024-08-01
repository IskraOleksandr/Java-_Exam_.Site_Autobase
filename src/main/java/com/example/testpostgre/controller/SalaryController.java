package com.example.testpostgre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.testpostgre.service.salaryservice.SalaryService;

import java.security.Principal;
import java.util.Collection;

@Controller
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @RequestMapping(value = "/salary/get", method = RequestMethod.GET)
    public String getSalary(Model model, Principal principal) {
        model.addAttribute("salary", salaryService.findAll());

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        Collection<GrantedAuthority> authorities = loginedUser.getAuthorities();
        StringBuilder roles = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            roles.append(authority.getAuthority());
        }

        model.addAttribute("roles", roles.toString());


        return "salary";
    }

}
