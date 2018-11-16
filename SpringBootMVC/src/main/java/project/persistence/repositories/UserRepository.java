package project.persistence.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.User;


public interface UserRepository extends JpaRepository<User, Long > {

    User save(User user);

    void delete(User user);

    List<User> findAll();

    @Query(value = "SELECT p FROM User p WHERE p.userName = ?1")
    List<User> getByUserName(String userName);

    //void register(User user);

//    User validateUser(Login login);

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
