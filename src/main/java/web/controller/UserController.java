package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.service.UserService;
import web.user.User;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @RequestMapping("/")
//    public String showAllUsers(Model model) {
//
//        List<User> allUsers = userService.getAllUser();
//        model.addAttribute("allUsers", allUsers);
//
//        return "all-users";
//    }
//
//    @RequestMapping("/addNewUser")
//    public String addUser(Model model) {
//
//        User user = new User();
//        model.addAttribute("user", user);
//
//        return "user-info";
//    }
//
//    @RequestMapping("/saveUser")
//    public String saveUser(@ModelAttribute("user") User user) {
//        userService.saveUser(user);
//
//        return "redirect:/";
//    }
//
//    @RequestMapping("/updateInfo")
//    public String updateUser(@RequestParam("userId") long id, Model model) {
//        User user = userService.getUser(id);
//        model.addAttribute("user", user);
//        return "user-info";
//
//    }
//    @RequestMapping("/deleteUser")
//    public String deleteUser(@RequestParam("userId") long id){
//        userService.deleteUser(id);
//
//        return "redirect:/";
//
//    }

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "all-users";
    }

    @GetMapping("/new")
    public String addUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "new-user";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "update-user";
    }

    @PatchMapping("/edit/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.updateUser(id,user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }


}
