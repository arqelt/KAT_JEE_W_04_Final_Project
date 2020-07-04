package pl.coderslab.finalproject.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.finalproject.domain.Report;
import pl.coderslab.finalproject.repository.ReportRepository;

import java.util.Optional;

public class ReportConverter implements Converter<String, Report> {

    @Autowired
    ReportRepository reportRepository;

    @Override
    public Report convert(String sourceId) {
        Optional<Report> byId = reportRepository.findById(Long.parseLong(sourceId));
        try {
            return byId.orElseThrow(Exception::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
