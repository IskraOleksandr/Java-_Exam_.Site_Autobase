package com.example.testpostgre.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.testpostgre.utils.WebUtils;

import java.io.Console;
import java.security.Principal;
import java.util.Collection;

@Controller
@RequiredArgsConstructor
public class MainController {
    @GetMapping(value = {"/", "/welcome"})
    public String welcomePage(Model model) {
        return "loginPage";
    }

    @GetMapping(value = "/login")
    public String loginPage(Model model, Principal principal) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        Collection<GrantedAuthority> authorities = loginedUser.getAuthorities();
        StringBuilder roles = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            roles.append(authority.getAuthority());
        }

        model.addAttribute("roles", roles.toString());

        return "loginPage";
    }

    @GetMapping(value = "/logoutSuccessful")
    public String logoutSuccessfulPage(Model model, Principal principal) {
        model.addAttribute("title", "Logout");
        model.addAttribute("roles", "ROLE_DEFAULT");

        return "logoutSuccessfulPage";
    }


    @GetMapping(value = "/userInfo")
    public String userInfo(Model model, Principal principal) {

        String userName = principal.getName();

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.pageInfoOutputMessageCreator(loginedUser);
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("userName", userName);

        Collection<GrantedAuthority> authorities = loginedUser.getAuthorities();
        StringBuilder roles = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            roles.append(authority.getAuthority());
        }

        model.addAttribute("roles", roles.toString());
        return "userInfoPage";
    }

}
