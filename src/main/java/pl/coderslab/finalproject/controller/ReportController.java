package pl.coderslab.finalproject.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.finalproject.domain.Facility;
import pl.coderslab.finalproject.domain.Report;
import pl.coderslab.finalproject.domain.ReportJsonRespone;
import pl.coderslab.finalproject.domain.Serviceman;
import pl.coderslab.finalproject.repository.FacilityRepository;
import pl.coderslab.finalproject.repository.ReportRepository;
import pl.coderslab.finalproject.repository.ServicemanRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/report")
public class ReportController {

    private ReportRepository reportRepository;
    private FacilityRepository facilityRepository;
    private ServicemanRepository servicemanRepository;

    public ReportController(ReportRepository reportRepository, FacilityRepository facilityRepository, ServicemanRepository servicemanRepository) {
        this.reportRepository = reportRepository;
        this.facilityRepository = facilityRepository;
        this.servicemanRepository = servicemanRepository;
    }

    @GetMapping("/all")
    public String getAllReports(Model model) {
        List<Report> reports = reportRepository.findAll();
        model.addAttribute("reports", reports);
        return "viewAllReports";
    }
    @GetMapping("/add")
    public String getSave(Model model) {
        model.addAttribute("report", new Report());
        return "addReport";
    }
    @PostMapping(value = "/add", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ReportJsonRespone postSave(@Valid @RequestBody Report report, BindingResult result) {
        ReportJsonRespone reportJsonRespone = new ReportJsonRespone();
        Optional<List<Report>> byServiceDateAndServiceman = reportRepository.findByServiceDateAndServiceman(report.getServiceDate(), report.getServiceman());
        System.out.println(report.getServiceman());
        byServiceDateAndServiceman.ifPresentOrElse(
                reports -> { throw new RuntimeException(); },
                () -> { reportRepository.save(report);
                    reportJsonRespone.setReport(report);
                }
                );
        return reportJsonRespone;
    }
    @GetMapping("/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) throws Exception {
        Optional<Report> byId = reportRepository.findById(id);
        Report report = byId.orElseThrow(Exception::new);
        model.addAttribute("report", report);
        return "editReport";
    }
    @PutMapping(value = "/edit/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ReportJsonRespone postEdit(@Valid @RequestBody Report report, @PathVariable Long id) {
        ReportJsonRespone reportJsonRespone = new ReportJsonRespone();
        reportRepository.customUpdate(
                report.getFacility(),
                report.getReportDate(),
                report.getServiceDate(),
                report.getServiceman(),
                report.getDescription(),
                id
        );
        reportJsonRespone.setReport(report);
        return reportJsonRespone;
    }
    @GetMapping(value = "/askForDelete/{id}")
    public String getDeleteConfirmation(Model model, @PathVariable Long id) throws Exception {
        Optional<Report> byId = reportRepository.findById(id);
        Report report = byId.orElseThrow(Exception::new);
        model.addAttribute("report", report);
        return "deleteReport";
    }
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ReportJsonRespone delete(@RequestBody @PathVariable Long id) throws Exception {
        ReportJsonRespone reportJsonRespone = new ReportJsonRespone();
        Optional<Report> byId = reportRepository.findById(id);
        Report report = byId.orElseThrow(Exception::new);
        reportRepository.delete(report);
        reportJsonRespone.setReport(report);
        return reportJsonRespone;
    }
    @ModelAttribute("facilities")
    public List<Facility> facilities() {
        return facilityRepository.findAll();
    }
    @ModelAttribute("servicemen")
    public List<Serviceman> servicemen() {
        return servicemanRepository.findAll();
    }

}
