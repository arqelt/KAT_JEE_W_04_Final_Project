package pl.coderslab.finalproject.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.finalproject.domain.Owner;
import pl.coderslab.finalproject.repository.OwnerRepository;

import java.util.Optional;

public class OwnerConverter implements Converter<String, Owner> {

    @Autowired
    OwnerRepository ownerRepository;

    @Override
    public Owner convert(String sourceId) {
        Optional<Owner> byId = ownerRepository.findById(Long.parseLong(sourceId));
        try {
            return byId.orElseThrow(Exception::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
