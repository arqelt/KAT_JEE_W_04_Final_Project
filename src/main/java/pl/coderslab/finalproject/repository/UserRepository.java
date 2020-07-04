package pl.coderslab.finalproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.finalproject.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

/*    @Modifying
    @Query("UPDATE User u set u.login = ?1, u.password = ?2, u.firstName = ?3, u.lastName = ?4")
    Optional<User> customUpdate(String login, String password, String firstName, String lastName);*/
}
