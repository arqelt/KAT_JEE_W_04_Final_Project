package pl.coderslab.finalproject.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;
import pl.coderslab.finalproject.domain.Report;
import pl.coderslab.finalproject.domain.ReportJsonRespone;
import pl.coderslab.finalproject.repository.FacilityRepository;
import pl.coderslab.finalproject.repository.ReportRepository;
import pl.coderslab.finalproject.repository.ServicemanRepository;

import java.time.LocalDate;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportControllerTest {

    @Autowired
    ReportRepository reportRepository;
    @Autowired
    FacilityRepository facilityRepository;
    @Autowired
    ServicemanRepository servicemanRepository;

    public ReportControllerTest() {

    }

    @Test
    public void postSave() {
        Report report = new Report();
        BindingResult bindingResult = null;

        ReportController reportController = new ReportController(reportRepository, facilityRepository,servicemanRepository);
        System.out.println((facilityRepository));
        report.setFacility(facilityRepository.findById(2L).get());

        report.setReportDate(LocalDate.of(2020,7,1));
        report.setServiceDate(LocalDate.of(2020,7,8));
        report.setServiceman(servicemanRepository.findById(1L).get());
        reportController.postSave(report, bindingResult);

        report.setFacility(facilityRepository.findById(2L).get());
        report.setReportDate(LocalDate.of(2020,7,1));
        report.setServiceDate(LocalDate.of(2020,7,8));
        report.setServiceman(servicemanRepository.findById(1L).get());
        reportController.postSave(report,bindingResult);

    }
}