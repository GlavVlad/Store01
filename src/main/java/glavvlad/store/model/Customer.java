package glavvlad.store.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.GroupSequence;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@GroupSequence({Customer.FirstCheck.class, Customer.class})
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"email", "username"}))
public class Customer implements Serializable {

    private static final long serialVersionUID = 1546977234998537862L;

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Must not be empty.")
    private String name;

    @Email(message = "It's not email", groups = FirstCheck.class)
    @Pattern(message = "It's not email", regexp = "^([A-Z|a-z|0-9](\\.|_){0,1})+[A-Z|a-z|0-9]\\@([A-Z|a-z|0-9])+((\\.){0,1}[A-Z|a-z|0-9]){2}\\.[a-z]{2,3}$")
//    @Column(unique = true)
    private String email;

    private String phone;

    @NotBlank(message = "Must not be empty.")
//    @Column(unique = true)
    private String username;

    @NotBlank(message = "Must not be empty.")
    private String password;

    private boolean enabled;

    @OneToOne
    @JoinColumn(name = "AddressId")
    private Address address;

    @OneToOne
    @JoinColumn(name = "CartId")
    private Cart cart;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    static class FirstCheck {
    }
}
