package project.service;

import project.persistence.entities.User;
import project.persistence.entities.Login;

import java.util.List;

public interface UserService {

    /**
     * save a {@Link User}
     * @param user {@Link User} to be saved
     * @return {@Link User} that was saved
     */



    User save(User user);

    /**
     * Delete {@link User}
     * @param user {@link User} to be deleted
     */



    void delete(User user);

    /**
     * Get all {@link User}s
     * @return A list of {@link User}s
     */




    List<User> findAll();

    /**
     * Get all {@link User}s in a reverse order
     * @return A reversed list of {@link User}s
     */

    //void register(User user);

    //User validateUser(Login login);

    /**
     * get  {@Link User} by {@String name}
     * @param name
     * @return A @Link(User}
     */


    List<User> getUserByName(String name);
}
