package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.finalproject.domain.Facility;
import pl.coderslab.finalproject.domain.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    @Modifying
    @Query("UPDATE Owner o set o.name = ?1, o.cityAddress = ?2, o.streetAddress = ?3, o.numberAddress = ?4, o.phone = ?5, o.email = ?6, o.description = ?7, o.facilityList = ?8")
    Optional<Owner> customUpdate(String name, String cityAddress, String streetAddress, String numberAddress, String phone, String email, String description, List<Facility> facility);
}
