package mk.ukim.finki.dians.web;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class LoginController {

    private final RestTemplate restTemplate;


    public LoginController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("bodyContent", "login");
        return "login.html";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Make a request to the authentication microservice
        String authMicroserviceUrl = "https://auth.thankfultree-7be29bbc.westeurope.azurecontainerapps.io/auth";
        String authMicroserviceEndpoint = authMicroserviceUrl + "/login";

        // Set the content type in the headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Customize this based on how your microservice expects the login request
        String loginRequestBody = "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}";

        // Create a request entity with the body and headers
        HttpEntity<String> requestEntity = new HttpEntity<>(loginRequestBody, headers);

        // Use exchange instead of postForObject for more control
        ResponseEntity<Boolean> responseEntity = restTemplate.exchange(
                authMicroserviceEndpoint,
                HttpMethod.POST,
                requestEntity,
                Boolean.class
        );

        boolean loginSuccessful = Boolean.TRUE.equals(responseEntity.getBody());

        // Process the response and handle success/failure accordingly
        if (loginSuccessful) {
            request.getSession().setAttribute("username", username);
            return "redirect:/map";
        } else {
            model.addAttribute("bodyContent", "login");
            model.addAttribute("hasError", true);
            model.addAttribute("error", "Invalid credentials");
            return "login.html";
        }
    }
}
