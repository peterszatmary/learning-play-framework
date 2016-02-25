package models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nue on 1.9.2015.
 */
@Entity
@Table(name = "lunchin_restaurant", schema = "lunchin@kunderaMongoDb_PU")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // v mongo db moze byt iba AUTO, TABLE nepodporovane
    @Column(name="ID")
    private String id; // v mongo db tuna musi byt string

    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type; //TODO better like Enum or ?

    @Column(name="description")
    private String description;

    @Embedded
    private RestaurantContact contact;

    @ManyToMany
    @JoinTable(
            name="",
            joinColumns = @JoinColumn(
                    name = "restaurant_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "user_id"
            )

    )
    private List<User> users;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RestaurantContact getContact() {
        return contact;
    }

    public void setContact(RestaurantContact contact) {
        this.contact = contact;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", contact=" + contact +
                '}';
    }
}
