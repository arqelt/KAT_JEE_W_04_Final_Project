package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.domain.Facility;
import pl.coderslab.finalproject.domain.Owner;
import pl.coderslab.finalproject.repository.FacilityRepository;
import pl.coderslab.finalproject.repository.OwnerRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/owner")
public class OwnerController {

    private OwnerRepository ownerRepository;
    private FacilityRepository facilityRepository;

    public OwnerController(OwnerRepository ownerRepository, FacilityRepository facilityRepository) {
        this.ownerRepository = ownerRepository;
        this.facilityRepository = facilityRepository;
    }

    @GetMapping("/all")
    public String getAllOwners(Model model) {
        List<Owner> owners = ownerRepository.findAll();
        model.addAttribute("owners", owners);
        return "viewAllOwners";
    }

    @GetMapping("/add")
    public String getSave(Model model) {
        model.addAttribute("owner", new Owner());
        return "addOwner";
    }
    @PostMapping("/add")
    public String postSave(@ModelAttribute Owner owner) {
        ownerRepository.save(owner);
        return "redirect:/owner/all";
    }
    @GetMapping("/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) throws Exception {
        Optional<Owner> byId = ownerRepository.findById(id);
        Owner owner = byId.orElseThrow(Exception::new);
        return "editOwner";
    }
    @PostMapping("/edit/{id}")
    public String postEdit(@ModelAttribute Owner owner, @PathVariable Long id) {
        ownerRepository.customUpdate(
                owner.getName(),
                owner.getCityAddress(),
                owner.getStreetAddress(),
                owner.getNumberAddress(),
                owner.getPhone(),
                owner.getEmail(),
                owner.getDescription(),
                owner.getFacilityList()
        );
        return "redirect:/owner/all";
    }
    @GetMapping(value = "/askForDelete/{id}")
    public String getDeleteConfirmation(Model model, @PathVariable Long id) throws Exception {
        Optional<Owner> byId = ownerRepository.findById(id);
        Owner owner = byId.orElseThrow(Exception::new);
        model.addAttribute("owner", owner);
        return "deleteOwner";
    }
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id) throws Exception {
        Optional<Owner> byId = ownerRepository.findById(id);
        Owner owner = byId.orElseThrow(Exception::new);
        ownerRepository.delete(owner);
        return "redirect:/owner/all";
    }
    @ModelAttribute("facilities")
    public List<Facility> facilities () {
        return facilityRepository.findAll();
    }
}
