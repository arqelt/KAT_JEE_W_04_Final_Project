package pl.coderslab.finalproject.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.domain.User;
import pl.coderslab.finalproject.service.CurrentUser;
import pl.coderslab.finalproject.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    //private final UserRepository userRepository;
    private final UserService userService;


    /*public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/create-admin")
    @ResponseBody
    public String createAdmin() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setFirstName("Arkadiusz");
        user.setLastName("Wilczek");
        userService.saveUser(user);
        return "admin";
    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("user");
        user.setPassword("user");
        user.setFirstName("Ambroży");
        user.setLastName("Kleks");
        userService.saveUser(user);
        return "user";
    }
    @GetMapping("/admin")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser customUser) {
        User entityUser = customUser.getUser();
        return "Hello " + entityUser.getUsername();
    }


    /*
    @GetMapping("/all")
    public String getAllUsers(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "viewAllUsers";
    }

    @PostMapping("/add")
    public String postSave(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/user/add";
    }

    @GetMapping("/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) throws Exception {
        Optional<User> byId = userRepository.findById(id);
        User user = byId.orElseThrow(Exception::new);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/edit/{id}")
    public String postEdit(@ModelAttribute User user, @PathVariable Long id) {
        userRepository.customUpdate(
                user.getLogin(),
                user.getPassword(),

                user.getFirstName(),
                user.getLastName()
        );
        return "redirect:/user/all";
    }

    @GetMapping(value = "/askForDelete/{id}")
    public String getDeleteConfirmation(Model model, @PathVariable Long id) throws Exception {
        Optional<User> byId = userRepository.findById(id);
        User user = byId.orElseThrow(Exception::new);
        model.addAttribute("user", user);
        return "deleteUser";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id) throws Exception {
        Optional<User> byId = userRepository.findById(id);
        User user = byId.orElseThrow(Exception::new);
        userRepository.delete(user);
        return "redirect:/user/all";
    }*/
}
