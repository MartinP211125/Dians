package mk.ukim.finki.dians.web;

import mk.ukim.finki.dians.service.WineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/map")
public class WineryController {

    public final WineService wineService;

    public WineryController(WineService wineService) {
        this.wineService = wineService;
    }

    @GetMapping
    public String getMap(Model model){
        model.addAttribute("winerys", wineService.findAll());
        return "map.html";
    }

    @GetMapping("/contact-us")
    public String getContactUs(){
        return "contact-us.html";
    }

    @GetMapping("/creators")
    public String getCreators(){
        return "creators.html";
    }
}
