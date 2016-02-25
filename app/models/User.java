package models;

/**
 * Created by nue on 31.8.2015.
 */

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "lunchin_user", schema = "lunchin@kunderaMongoDb_PU")
@NamedQuery(name = User.USER_EXIST, query = "SELECT u FROM User u WHERE u.email=:email AND u.password=:password")// is faster
// to determine the DB name and collection name keyspace@persistenceunitname
public class User {

    public static final String USER_EXIST = "userExist";

    //TODO ??? ID ? mongo db si vytvara vlastne tak neviem
//    @Id
//    @Column(name="ID")
//    private UUID id;

//    @Id
//    @Column(name="ID")
//    private String id;

    @Id @GeneratedValue(strategy = GenerationType.AUTO) // v mongo db moze byt iba AUTO, TABLE nepodporovane
    @Column(name="ID")
    private String id; // v mongo db tuna musi byt string

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="account_name", nullable = false)
    private String accountName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "birth")
    private Date birth;

    @Column(name = "password", nullable = false)
    private String password;

    // i know this should be in UserCOntact but i dont know how create namedquery in User where you have email.
    @Column(name="email", unique = true)
    private String email;

    @Embedded
    private UserContact contact;

    @Column(name = "ban", nullable = false)
    private Boolean ban;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @ManyToMany(mappedBy = "users") // Restaurant.users
    private List<Restaurant> restaurants;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getBan() {
        return ban;
    }

    public void setBan(Boolean ban) {
        this.ban = ban;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserContact getContact() {
        return contact;
    }

    public void setContact(UserContact contact) {
        this.contact = contact;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", accountName='" + accountName + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", password=" + password +
                ", contact=" + contact +
                ", ban=" + ban +
                ", active=" + active +
                ", email=" + email +
                '}';
    }
}
