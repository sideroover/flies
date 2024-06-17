package eu.epfc.j1888.fly.controllers;

import eu.epfc.j1888.fly.repositories.AirportRepository;
import eu.epfc.j1888.fly.entities.Fly;
import eu.epfc.j1888.fly.repositories.FlyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import lombok.*;
import java.util.List;
@AllArgsConstructor
@Getter
@Setter
@ToString
@Controller
public class FlyController {
    private final FlyRepository flyRepository;
    private final AirportRepository airportRepository;

    @GetMapping("/flies")
    public String showFlies(Model model) {
        List<Fly> flies = flyRepository.findAll();
        model.addAttribute("flies", flies);
        return "flies";
        // renvoie vers le fichier html qui se trouve dans resources>templates
    }

    @GetMapping("/flies/create")
    public String showFlyForm(Model model){
        Fly fly = new Fly();
        model.addAttribute("fly", fly);
        model.addAttribute("airports", airportRepository.findAll());
        return "fly-create";
    }

    @PostMapping("/flies")
    public String createFlyProcessor(@ModelAttribute("flies") Fly fly) {
        flyRepository.save(fly);
        return "redirect:/flies";
    }
}
