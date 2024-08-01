package com.example.testpostgre.controller;

import com.example.testpostgre.dto.TruckRepairDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.testpostgre.model.*;
import com.example.testpostgre.service.truckrepairservice.TruckRepairService;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

@Controller
public class TruckRepairController {

    @Autowired
    private TruckRepairService repairService;

    @RequestMapping(value = "/truckrepair/get", method = RequestMethod.GET)
    public String getTruckRepair(Model model, Principal principal) {

        model.addAttribute("truckrepair", repairService.findWithRemainingRepairDays());

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        Collection<GrantedAuthority> authorities = loginedUser.getAuthorities();
        StringBuilder roles = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            roles.append(authority.getAuthority());
        }

        model.addAttribute("roles", roles.toString());

        return "truckrepair";
    }

}
