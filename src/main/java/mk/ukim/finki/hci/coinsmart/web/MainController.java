package mk.ukim.finki.hci.coinsmart.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {

    @GetMapping({"/", "/home"})
    public String getHomePage(Model model){
        model.addAttribute("bodyContent", "home");
        model.addAttribute("pageTitle", "Home");
        return "master-template";
    }

    @GetMapping("/learn")
    public String getCoursesPage(Model model){
        model.addAttribute("bodyContent", "courses");
        model.addAttribute("pageTitle", "Courses");
        return "master-template";
    }

    @GetMapping("/learn/what-is-cryptocurrency")
    public String getCourseOnePage(Model model){
        model.addAttribute("bodyContent", "what-is-cryptocurrency");
        model.addAttribute("pageTitle", "What is Cryptocurrency?");
        return "master-template";
    }
}
