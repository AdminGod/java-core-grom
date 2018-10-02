package finalProject.model;

import java.util.Objects;

public class User extends BaseModel {

    private String userName;
    private String password;
    private String country;
    UserType role;

    public User(long id, String userName, String password, String country, UserType role) {
        super(id);
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.role = role;
    }

    public User(String userName, String password, String country, UserType role) {
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.role = role;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UserType getRole() {
        return role;
    }

    public void setRole(UserType role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(country, user.country) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password, country, role);
    }
}
