package pl.coderslab.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.finalproject.domain.Facility;
import pl.coderslab.finalproject.domain.Report;
import pl.coderslab.finalproject.domain.Serviceman;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReportRepository extends JpaRepository<Report, Long> {


    Optional<List<Report>> findByServiceDateAndServiceman(LocalDate serviceDate, Serviceman serviceman);

    @Modifying
    @Transactional
    @Query("update Report r set r.facility = ?1, r.reportDate = ?2, r.serviceDate = ?3, r.serviceman = ?4, r.description = ?5 WHERE r.id = ?6")
    void customUpdate(Facility facility, LocalDate reportDate, LocalDate serviceDate, Serviceman serviceman, String description, Long id);
}
