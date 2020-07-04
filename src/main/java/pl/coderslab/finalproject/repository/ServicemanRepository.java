package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.finalproject.domain.Report;
import pl.coderslab.finalproject.domain.Serviceman;

import java.util.List;
import java.util.Optional;

public interface ServicemanRepository extends JpaRepository<Serviceman, Long> {

    @Modifying
    @Query("UPDATE Serviceman s set s.firstName = ?1, s.lastName = ?2")
    Optional<Serviceman> customUpdate(String firstName, String lastName);
}
