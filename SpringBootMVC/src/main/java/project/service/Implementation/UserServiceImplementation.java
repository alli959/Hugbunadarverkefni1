package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.User;
import project.persistence.entities.Login;
//import project.persistence.repositories.PlayerRepository;
import project.persistence.repositories.UserRepository;
import project.service.UserService;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService{

    UserRepository userRepository;


    @Autowired
    public UserServiceImplementation(UserRepository repository) { this.userRepository = repository;}


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {

        userRepository.delete(user);

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUserByName(String name) {
        return userRepository.getUserByName(name);
    }

    //public void register(User user) {
        // TODO Auto-generated method stub
        //userRepository.register(user);
    //}


    //public User validateUser(Login login) {
        // TODO Auto-generated method stub

        //return null;
        //return userRepository.validateUser(login);
    //}

}