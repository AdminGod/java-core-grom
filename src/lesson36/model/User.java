package lesson36.model;

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
}
