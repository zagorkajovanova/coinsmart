package mk.ukim.finki.hci.coinsmart.web;

import mk.ukim.finki.hci.coinsmart.model.enums.Role;
import mk.ukim.finki.hci.coinsmart.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.hci.coinsmart.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false)String error, Model model) {
        if(error!=null && !error.isEmpty()){
            model.addAttribute("error", error);
        }

        model.addAttribute("pageTitle", "CoinSmart - Register");
        model.addAttribute("bodyContent", "register");

        return "master-template";
    }

    @PostMapping
    public String register(@RequestParam String fullName,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatPassword){

        Role role = Role.ROLE_USER;

        this.userService.register(username,password,repeatPassword,fullName,role);
        return "redirect:/login";
    }


}
