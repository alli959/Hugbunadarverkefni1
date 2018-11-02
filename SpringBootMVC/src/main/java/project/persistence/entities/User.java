package project.persistence.entities;


import javax.persistence.*;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer USERID;
    private String name;
    private String userName;
    private String password;
    private String email;
    //private Team team;


    public User() {
    }

    public User(Integer USERID, String name, String userName, String password, String email) {
        this.USERID = USERID;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public Integer getUSERID() {
        return USERID;
    }

    public void setUSERID(Integer USERID) {
        this.USERID = USERID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
