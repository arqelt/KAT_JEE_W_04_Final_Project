package pl.coderslab.finalproject.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.finalproject.domain.Serviceman;
import pl.coderslab.finalproject.repository.ServicemanRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public class ServicemanConverter implements Converter <String, Serviceman> {

    @Autowired
    ServicemanRepository servicemanRepository;

    @Override
    public Serviceman convert(String sourceId) {
        Optional<Serviceman> byId = servicemanRepository.findById(Long.parseLong(sourceId));
        try {
            return byId.orElseThrow(Exception::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
