package com.example.testpostgre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.testpostgre.model.Route;
import com.example.testpostgre.service.createrouteservice.CreateRouteService;
import com.example.testpostgre.service.route.RouteService;

import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
public class RouteController {

    @Autowired
    CreateRouteService createRouteService;

    @Autowired
    RouteService routeService;

    @RequestMapping(value = "/routes/get", method = RequestMethod.GET)
    public String getRoutes(Model model, Principal principal) {
        List<Route> routes = routeService.findAll();
        Collections.sort(routes, Comparator.comparingInt(Route::getDate));
        model.addAttribute("routes", routeService.findAll());

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        Collection<GrantedAuthority> authorities = loginedUser.getAuthorities();
        StringBuilder roles = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            roles.append(authority.getAuthority());
        }

        model.addAttribute("roles", roles.toString());


        return "routes";
    }


}
