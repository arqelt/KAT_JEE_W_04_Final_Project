package pl.coderslab.finalproject.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.finalproject.domain.Facility;
import pl.coderslab.finalproject.repository.FacilityRepository;

import java.util.Optional;

public class FacilityConverter implements Converter<String, Facility> {
    @Autowired
    FacilityRepository facilityRepository;

    @Override
    public Facility convert(String sourceId) {
        Optional<Facility> byId = facilityRepository.findById(Long.parseLong(sourceId));
        try {
            return byId.orElseThrow(Exception::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
