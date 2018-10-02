package lessons.lesson15.hw1;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public User save(User u) {
        if (findUser(u) == null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] == null) {
                    users[i] = u;
                    return u;
                }
            }
        }
        return null;
    }

    public User update(User u) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == u.getId()) {
                users[i] = u;
                return u;
            }
        }
        return null;
    }

    public void delete(long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == id) {
                users[i] = null;
                break;
            }
        }
    }

    public User findUser(User u) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].equals(u)) {
                return users[i];
            }
        }
        return null;
    }
}
