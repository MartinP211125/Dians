package mk.ukim.finki.dians.web;


import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.dians.model.User;
import mk.ukim.finki.dians.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.dians.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.dians.service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final AuthenticationService authService;

    public LoginController(AuthenticationService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String getLoginPage(Model model) {
        model.addAttribute("bodyContent", "login");
        return "login.html";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model) {
        User user = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            user = authService.login(username, password);
        } catch (InvalidUserCredentialsException | InvalidArgumentsException exception) {
            model.addAttribute("bodyContent", "login");
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login.html";
        }

        request.getSession().setAttribute("user", user);
        return "redirect:/map";
    }
}
