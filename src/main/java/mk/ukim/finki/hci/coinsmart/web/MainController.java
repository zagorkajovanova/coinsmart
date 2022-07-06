package mk.ukim.finki.hci.coinsmart.web;

import mk.ukim.finki.hci.coinsmart.model.Course;
import mk.ukim.finki.hci.coinsmart.model.User;
import mk.ukim.finki.hci.coinsmart.service.CourseService;
import mk.ukim.finki.hci.coinsmart.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class MainController {

    private final UserService userService;
    private final CourseService courseService;

    public MainController(UserService userService, CourseService courseService) {
        this.userService = userService;
        this.courseService = courseService;
    }

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

    @GetMapping("/learn/finished/{username}/{courseId}")
    public String markCourse(@PathVariable String username,
                             @PathVariable String courseId){

        User user = this.userService.findByUsername(username);
        Long id = Long.parseLong(courseId);
        Course course = this.courseService.findById(id);

        this.userService.addCompletedCourse(user, course);
        return "redirect:/learn/completed-course";
    }

    @GetMapping("/profile/user/{username}")
    public String getProfilePage(@PathVariable String username, Model model){

        User user = this.userService.findByUsername(username);

        model.addAttribute("user", user);
        model.addAttribute("bodyContent", "profile");
        model.addAttribute("pageTitle", "CoinSmart - Profile");

        return "master-template";
    }

    @PostMapping("/profile/edit/{id}")
    public String editProfile(@PathVariable Long id,
                              @RequestParam String fullName,
                              @RequestParam String username,
                              @RequestParam String email){

        this.userService.update(id, username, fullName, email);

        return "redirect:/profile/user/" + username;
    }
}
