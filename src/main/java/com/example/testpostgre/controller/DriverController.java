package com.example.testpostgre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.testpostgre.model.Driver;
import com.example.testpostgre.service.driverservice.DriverService;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
public class DriverController {

    @Autowired
    private DriverService dService;

    @RequestMapping(value = "/drivers/get", method = RequestMethod.GET)
    public String getDrivers(Model model, Principal principal) {
        model.addAttribute("drivers", dService.findAll());

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        Collection<GrantedAuthority> authorities = loginedUser.getAuthorities();
        StringBuilder roles = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            roles.append(authority.getAuthority());
        }

        model.addAttribute("roles", roles.toString());
        return "drivers";
    }


    @RequestMapping(value = "/drivers/create", method = RequestMethod.POST)
    public String createDriver(@RequestParam("fullName") String updateName,
                               @RequestParam("expirience") int exp,
                               @RequestParam("age") int age,
                               Model model) {
        Driver addDriver = new Driver();
        addDriver.setFullName(updateName);
        addDriver.setExpirience(exp);
        addDriver.setAge(age);
        addDriver.setAvailable(true);
        dService.save(addDriver);
        return "redirect:/drivers/get";
    }


    @GetMapping(value = "/createDriver")
    public String createDriverPage(Model model, Principal principal) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        Collection<GrantedAuthority> authorities = loginedUser.getAuthorities();
        StringBuilder roles = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            roles.append(authority.getAuthority());
        }

        model.addAttribute("roles", roles.toString());

        return "createDriver";
    }

    @GetMapping(value = "/updateDriver")
    public String updateDriverPage(Model model, Principal principal) {
        model.addAttribute("drivers", dService.findAll());

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        Collection<GrantedAuthority> authorities = loginedUser.getAuthorities();
        StringBuilder roles = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            roles.append(authority.getAuthority());
        }

        model.addAttribute("roles", roles.toString());

        return "updateDriver";
    }

    @RequestMapping(value = "/drivers/update", method = RequestMethod.POST)
    public String updateDriver(@RequestParam("driverId") Long id,
                               @RequestParam("newExpirience") String exp,
                               Model model, Principal principal) {
        List<Driver> findDriver = dService.findByIdLike(id);
        if (findDriver.size() != 0) {
            Optional<Driver> updateDRiver = Optional.ofNullable(findDriver.get(0));
            if (updateDRiver.isPresent()) {
                updateDRiver.get().setFullName(findDriver.get(0).getFullName());
                updateDRiver.get().setExpirience(Integer.parseInt(exp));
                updateDRiver.get().setAge(findDriver.get(0).getAge());
                updateDRiver.get().setAvailable(findDriver.get(0).isAvailable());
                dService.save(updateDRiver.get());
            }
        }
//
        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        Collection<GrantedAuthority> authorities = loginedUser.getAuthorities();
        StringBuilder roles = new StringBuilder();
        for (GrantedAuthority authority : authorities) {
            roles.append(authority.getAuthority());
        }

        model.addAttribute("roles", roles.toString());

        return "redirect:/drivers/get";
    }

    @GetMapping(value = "/deleteDriver")
    public String deleteDriverPage(Model model) {
        model.addAttribute("drivers", dService.findAll());
        return "deleteDriver";
    }
}
