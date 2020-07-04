package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.domain.Serviceman;
import pl.coderslab.finalproject.repository.ServicemanRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/serviceman")
public class ServicemanController {

    ServicemanRepository servicemanRepository;

    public ServicemanController(ServicemanRepository servicemanRepository) {
        this.servicemanRepository = servicemanRepository;
    }
    @GetMapping("/all")
    public String getAllServicemen(Model model) {
        List<Serviceman> servicemen = servicemanRepository.findAll();
        model.addAttribute("servicemen", servicemen);
        return "viewAllServicemen";
    }
    @GetMapping("/add")
    public String getSave(Model model) {
        model.addAttribute("serviceman", new Serviceman());
        return "addServicemen";
    }
    @PostMapping("/add")
    public String postSave(@ModelAttribute Serviceman serviceman) {
        servicemanRepository.save(serviceman);
        return "redirect:/serviceman/all";
    }
    @GetMapping("/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) throws Exception {
        Optional<Serviceman> byId = servicemanRepository.findById(id);
        Serviceman serviceman = byId.orElseThrow(Exception::new);
        model.addAttribute("serviceman", serviceman);
        return "editServiceman";
    }
    @PostMapping("/edit/{id}")
    public String postEdit(@ModelAttribute Serviceman serviceman, @PathVariable Long id) {
        servicemanRepository.customUpdate(
                serviceman.getFirstName(),
                serviceman.getLastName());
        return "redirect/serviceman/all";
    }
    @GetMapping("/askForDelete/{id}")
    public String getDeleteConfirmation(Model model, @PathVariable Long id) throws Exception {
        Optional<Serviceman> byId = servicemanRepository.findById(id);
        Serviceman serviceman = byId.orElseThrow(Exception::new);
        model.addAttribute("serviceman", serviceman);
        return "deleteServiceman";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id) throws Exception {
        Optional<Serviceman> byId = servicemanRepository.findById(id);
        Serviceman serviceman = byId.orElseThrow(Exception::new);
        servicemanRepository.delete(serviceman);
        return "redirect:/serviceman/all";
    }

}
