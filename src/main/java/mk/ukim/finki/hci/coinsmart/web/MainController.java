package mk.ukim.finki.hci.coinsmart.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/learn/what-is-blockchain")
    public String getCourseTwoPage(Model model){
        model.addAttribute("bodyContent", "what-is-blockchain");
        model.addAttribute("pageTitle", "What is Blockchain?");
        return "master-template";
    }

    @GetMapping("/learn/what-is-ethereum")
    public String getCourseThreePage(Model model){
        model.addAttribute("bodyContent", "what-is-ethereum");
        model.addAttribute("pageTitle", "What is Ethereum?");
        return "master-template";
    }

    @GetMapping("/learn/what-is-bitcoin")
    public String getCourseFourPage(Model model){
        model.addAttribute("bodyContent", "what-is-bitcoin");
        model.addAttribute("pageTitle", "What is Bitcoin?");
        return "master-template";
    }

    @GetMapping("/learn/bitcoin-scarcity-trust-in-money")
    public String getCourseFivePage(Model model){
        model.addAttribute("bodyContent", "bitcoin-scarcity");
        model.addAttribute("pageTitle", "Bitcoin, scarcity & trust in money");
        return "master-template";
    }

    @GetMapping("/learn/building-on-top-of-bitcoin")
    public String getCourseSixPage(Model model){
        model.addAttribute("bodyContent", "building-on-top");
        model.addAttribute("pageTitle", "Building on top of Bitcoin");
        return "master-template";
    }

    @GetMapping("learn/completed-course")
    public String getCompletedCoursePage(Model model){
        model.addAttribute("bodyContent", "completed-course");
        model.addAttribute("pageTitle", "Course completed");
        return "master-template";
    }

    @PostMapping("/learn/finished")
    public String markCourse(@RequestParam String course){
        return "redirect:/learn/completed-course";
    }
}
