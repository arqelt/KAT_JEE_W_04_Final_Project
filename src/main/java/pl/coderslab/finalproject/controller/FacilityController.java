package pl.coderslab.finalproject.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.domain.Facility;
import pl.coderslab.finalproject.domain.FacilityJsonRespone;
import pl.coderslab.finalproject.domain.Owner;
import pl.coderslab.finalproject.repository.FacilityRepository;
import pl.coderslab.finalproject.repository.OwnerRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    private FacilityRepository facilityRepository;
    private OwnerRepository ownerRepository;

    public FacilityController(FacilityRepository facilityRepository, OwnerRepository ownerRepository) {
        this.facilityRepository = facilityRepository;
        this.ownerRepository = ownerRepository;
    }

    @GetMapping("/all")
    public String getAllFacilities(Model model) {
        List<Facility> facilities = facilityRepository.findAll();
        model.addAttribute("facilities", facilities);
        return "viewAllFacilities";
    }
    @GetMapping("/add")
    public String getSave(Model model) {
        model.addAttribute("facility",new Facility());
        return "addFacility";
    }
    @PostMapping(value = "/add", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public FacilityJsonRespone postSave(@Valid @RequestBody Facility facility) {
        FacilityJsonRespone facilityJsonRespone = new FacilityJsonRespone();
        facilityRepository.save(facility);
        facilityJsonRespone.setFacility(facility);
        return facilityJsonRespone;
    }
    @GetMapping(value = "/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) throws Exception {
        Optional<Facility> byId = facilityRepository.findById(id);
        Facility facility = byId.orElseThrow(Exception::new);
        model.addAttribute("facility", facility);
        return "editFacility";
    }
    @PutMapping(value = "/edit/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public FacilityJsonRespone postEdit(@Valid @RequestBody Facility facility, @PathVariable Long id) {
        FacilityJsonRespone facilityJsonRespone = new FacilityJsonRespone();
        facilityRepository.customUpdate(
                facility.getName(),
                facility.getOwner(),
                facility.getCityAddress(),
                facility.getStreetAddress(),
                facility.getNumberAddress(),
                facility.getPhone(),
                facility.getEmail(),
                facility.getDescription(),
                id
        );
        facilityJsonRespone.setFacility(facility);
        return facilityJsonRespone;
    }
    @GetMapping(value = "/askForDelete/{id}")
    public String getDeleteConfirmation(Model model, @PathVariable Long id) throws Exception {
        Optional<Facility> byId = facilityRepository.findById(id);
        Facility facility = byId.orElseThrow(Exception::new);
        model.addAttribute("facility", facility);
        return "deleteFacility";
    }
    @DeleteMapping(value = "/delete/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public FacilityJsonRespone delete(@RequestBody @PathVariable Long id) throws Exception {
        FacilityJsonRespone facilityJsonRespone = new FacilityJsonRespone();
        Optional<Facility> byId = facilityRepository.findById(id);
        Facility facility = byId.orElseThrow(Exception::new);
        facilityRepository.delete(facility);
        facilityJsonRespone.setFacility(facility);
        return facilityJsonRespone;
    }
    @ModelAttribute("owners")
    public List<Owner> owners() {
        return ownerRepository.findAll();
    }
}
