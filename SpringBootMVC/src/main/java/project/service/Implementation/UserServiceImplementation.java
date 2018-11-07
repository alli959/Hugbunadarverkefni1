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

    public UserRepository userRep;


    @Autowired
    public UserServiceImplementation(UserRepository repository) { this.userRep = repository;}


    @Override
    public User save(User user) {
        return userRep.save(user);
    }

    @Override
    public void delete(User user) {

        userRep.delete(user);

    }

    @Override
    public List<User> findAll() {
        return userRep.findAll();
    }

    public void register(User user) {
        // TODO Auto-generated method stub
        //userRep.register(user);
    }


    public User validateUser(Login login) {
        // TODO Auto-generated method stub

        return null;
        //return userRep.validateUser(login);
    }

}