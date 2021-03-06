package glavvlad.store.model;

import javax.persistence.*;

@Entity(name = "Users")
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"ID", "Username"}))
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    private boolean enabled;
    private int customerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
