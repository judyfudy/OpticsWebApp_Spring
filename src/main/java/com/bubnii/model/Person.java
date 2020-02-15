package com.bubnii.model;

import com.bubnii.enums.PersonType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idPerson;

    @Column(name = "username")
    private String username;

    @Column(name = "pass")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "person_type")
    private PersonType personType;

    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "cart",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id")}
    )
    private List<Product> productList = new LinkedList<>();

    public Person() {
    }

    public Person(int idPerson, String username, String password, String firstName, String lastName, String email, PersonType personType) {
        this.idPerson = idPerson;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.personType = personType;
    }

    public Person(String username, String password, String firstName, String lastName, String email, PersonType personType) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.personType = personType;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Person))
            return false;

        Person person = (Person) o;

        return idPerson == person.idPerson
                && username.equals(person.username)
                && password.equals(person.password)
                && firstName.equals(person.firstName)
                && lastName.equals(person.lastName)
                && email.equals(person.email)
                && personType == person.personType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson, username, password, firstName, lastName, email, personType);
    }

    @Override
    public String toString() {
        return "Person [" +
                "idPerson=" + idPerson +
                ", username=" + username +
                ", password=" + password +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", email=" + email +
                ", personType=" + personType +
                ']';
    }
}
