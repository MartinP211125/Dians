package mk.ukim.finki.dians.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final RestTemplate restTemplate;


    public RegisterController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        model.addAttribute("bodyContent", "register");
        return "register.html";
    }

    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatedPassword,
                           @RequestParam String email) {
        // Make a request to the authentication microservice for registration
        String authMicroserviceUrl = "https://auth.thankfultree-7be29bbc.westeurope.azurecontainerapps.io/auth";
        String authMicroserviceEndpoint = authMicroserviceUrl + "/register";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Customize this based on how your microservice expects the registration request
        String registerRequestBody = "{\"username\":\"" + username + "\",\"password\":\"" + password +
                "\",\"repeatPassword\":\"" + repeatedPassword + "\",\"email\":\"" + email + "\"}";
        HttpEntity<String> requestEntity = new HttpEntity<>(registerRequestBody, headers);

        String response = restTemplate.postForObject(authMicroserviceEndpoint, requestEntity, String.class);

        // Process the response and handle success/failure accordingly
        if ("User registered successfully".equals(response)) {
            return "redirect:/login";
        } else {
            return "redirect:/register?error=" + response;
        }
    }
}
