package project.persistence.repositories;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.User;
import project.persistence.entities.Login;


public interface UserRepository extends JpaRepository<User, Long > {

    User save(User player);

    void delete(User player);

    List<User> findAll();

    //@Query(value = "")
    //void register(User user);

    //@Query(value = "SELECT p FROM Player p where length(p.name) >= 3 ")
    //List<Player> findAllWithNameLongerThan3Chars();


    //public void register(User user) {
      //  String sql = "insert into users values(?,?,?,?,?,?,?)";
        //jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
          //      user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone() });
   // }
   // public User validateUser(Login login) {
     //   String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
      //          + "'";
    //    List<User> users = jdbcTemplate.query(sql, new UserMapper());
    //    return users.size() > 0 ? users.get(0) : null;
   // }
}
