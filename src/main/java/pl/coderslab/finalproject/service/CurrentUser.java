package pl.coderslab.finalproject.service;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {

    private final pl.coderslab.finalproject.domain.User user;

    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       pl.coderslab.finalproject.domain.User user) {
        super(username, password, authorities);
        this.user = user;
    }

    public pl.coderslab.finalproject.domain.User getUser() {
        return user;
    }
}
