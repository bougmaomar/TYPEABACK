package com.projecttypea.typea.ws;

import java.util.List;

//import javax.transaction.Transactional;

import com.projecttypea.typea.bean.User;
import com.projecttypea.typea.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController

public class UserWS {

    @Autowired
    UserService userService;

    @GetMapping("/admin/username/{name}")
    public User findByNom(String name) {
        return userService.findByNom(name);
    }

    @PostMapping("/allusers/login")
    public int loginUser(@RequestBody User user, HttpSession session) {
        return userService.loginUser(user, session);
    }

    @GetMapping("/allusers/logout")
    public int logoutUser(HttpSession session) {
        if (session.getAttribute("session") != null) {
            session.removeAttribute("session");
            return 1;
        } else {
            return -1;
        }
    }

    @PutMapping("/user/updateuser/{id}")
    public int updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @GetMapping("/user/email/{email}")
    public User findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @GetMapping("/admin/Users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/allusers/register")
    public String addUser(@Valid @RequestBody User utilisateur) {
        return userService.addUser(utilisateur);
    }

    @GetMapping("/admin/getuserbyid/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

}
