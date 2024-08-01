package com.example.testpostgre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.testpostgre.model.*;
import com.example.testpostgre.service.statisticservice.StatisticService;

import java.security.Principal;
import java.util.Collection;

@Controller
public class StatisticController {


    @Autowired
    private StatisticService statService;

    @RequestMapping(value = "/statistic", method = RequestMethod.GET)
    public String getStat(Model model, Principal principal) {
        model.addAttribute("driver", statService.findDriver());
        model.addAttribute("destination", statService.findDestination());
        model.addAttribute("cargo", statService.findCargo());
        model.addAttribute("mincargo", statService.findMinWeightCargo());
        model.addAttribute("orders", statService.findCargoIn());

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        Collection<GrantedAuthority> authorities = loginedUser.getAuthorities();
        StringBuilder roles = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            roles.append(authority.getAuthority());
        }

        model.addAttribute("roles", roles.toString());


        return "statistic";
    }


}
