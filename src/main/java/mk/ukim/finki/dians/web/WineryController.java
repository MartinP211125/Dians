package mk.ukim.finki.dians.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/map")
public class WineryController {

    @GetMapping
    public String getMap(Model model){
        return "map.html";
    }
}
