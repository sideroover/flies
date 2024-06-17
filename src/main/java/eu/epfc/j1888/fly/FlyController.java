package eu.epfc.j1888.fly;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FlyController {
    private final FlyRepository repository;

    public FlyController(FlyRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/flies")
    public String showFlies(Model model) {
        List<Fly> flies = repository.findAll();
        model.addAttribute("flies", flies);
        return "flies";
        // renvoie vers le fichier html qui se trouve dans resources>templates
    }

    @GetMapping("/flies/create")
    public String showFlyForm(Model model){
        Fly fly = new Fly();
        model.addAttribute("fly", fly);
        return "fly-create";
    }

    @PostMapping("/flies")
    public String createFlyProcessor(@ModelAttribute("flies") Fly fly) {
        repository.save(fly);
        return "redirect:/flies";
    }
}
