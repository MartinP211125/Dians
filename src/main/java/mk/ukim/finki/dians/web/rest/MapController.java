package mk.ukim.finki.dians.web.rest;

import mk.ukim.finki.dians.model.Wine;
import mk.ukim.finki.dians.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/wines")
public class MapController {

    private final WineService wineService;

    public MapController(WineService wineService){
        this.wineService = wineService;
    }

    @GetMapping
    public ResponseEntity<?> getWines(@RequestParam(name = "name", required = false) String name) {
        if (name != null && !name.isEmpty()) {
            Optional<Wine> wine = wineService.findByName(name).stream().findFirst();
            if (wine.isPresent()) {
                return new ResponseEntity<>(wine, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Wine not found", HttpStatus.NOT_FOUND);
            }
        } else {
            List<Wine> wines = wineService.findAll();
            return new ResponseEntity<>(wines, HttpStatus.OK);
        }
    }
}