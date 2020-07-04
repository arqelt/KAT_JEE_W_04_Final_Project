package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.finalproject.domain.Facility;
import pl.coderslab.finalproject.domain.Owner;

import java.util.Optional;

public interface FacilityRepository extends JpaRepository<Facility, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Facility f set f.name = ?1, f.owner = ?2, f.cityAddress = ?3, f.streetAddress = ?4, f.numberAddress = ?5, f.phone = ?6, f.email = ?7, f.description = ?8 WHERE f.id = ?9")
    void customUpdate(String name, Owner owner, String cityAddress, String streetAddress, String numberAddress, String phone, String email, String description, Long id);
}
