package pl.coderslab.finalproject.service;

import pl.coderslab.finalproject.domain.User;

public interface UserService {

    User findByUserName (String name);

    void saveUser (User user);
}
