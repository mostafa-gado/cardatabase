package com.packt.cardatabase.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long ownerid;
    private String firstname, lastname;

    /*
    The @OneToMany annotation has two attributes that we are using. The cascade attribute
    defines how cascading affects the entities in the case of deletions or updates. The ALL
    attribute setting means that all operations are cascaded. For example, if the owner is
    deleted, the cars that are linked to that owner are deleted as well. The mappedBy="owner"
    attribute setting tells us that the Car class has the owner field, which is the foreign
    key for this relationship.
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Car> cars;

    public Owner() {}
    public Owner(String firstname, String lastname) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public long getOwnerid() {
        return ownerid;
    }
    public void setOwnerid(long ownerid) {
        this.ownerid = ownerid;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
