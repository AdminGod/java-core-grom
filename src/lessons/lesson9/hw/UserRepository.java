package lessons.lesson9.hw;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames() {
        if(users != null) {
            int counter = 0;
            for (int i = 0; i < users.length; i++) {
                if (users[i] != null) {
                    counter++;
                }
            }
            String[] userNames = new String[counter];
            counter=0;
            for (int i = 0; i < users.length; i++) {
                if (users[i] != null) {
                    userNames[counter] = users[i].getName();
                    counter++;
                }
            }
            return userNames;
        }
        return new String[0];
    }

    public long[] getUserIds() {
        if(users != null) {
            int counter = 0;
            for (int i = 0; i < users.length; i++) {
                if (users[i] != null) {
                    counter++;
                }
            }
            long[] userIds = new long[counter];
            counter = 0;
            for (int i = 0; i < users.length; i++) {
                if (users[i] != null) {
                    userIds[counter] = users[i].getId();
                    counter++;
                }
            }
            return userIds;
        }
        return new long[0];
    }

    public String getUserNameById(long id) {
        if(users!=null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] != null) {
                    if (users[i].getId() == id) {
                        return users[i].getName();
                    }
                }
            }
        }
        return null;
    }

    public User getUserByName(String name) {
        if(users!=null && name != null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] != null) {
                    if (users[i].getName() == name) {
                        return users[i];
                    }
                }
            }
        }
        return null;
    }

    private User findById(long id) {
        if(users!=null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] != null) {
                    if (users[i].getId() == id) {
                        return users[i];
                    }
                }
            }
        }
        return null;
    }

    public User getUserBySessionId(String sessionId) {
        if(users!= null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] != null) {
                    if (users[i].getSessionId() == sessionId) {
                        return users[i];
                    }
                }
            }
        }
        return null;
    }

    public User save (User user){
        if(users == null){
            users = new User[1];
            users[0] = user;
            return user;
        }
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return user;
            }
            if (users[i].getId() == user.getId()) {
                return null;
            }
        }
        return null;
    }

    public User update (User user){
        if(users == null || user == null){
            return null;
        }
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                if (users[i].getId() == user.getId()) {
                    users[i] = user;
                    return user;
                }
            }
        }
        return null;
    }

    public void delete (long id){
        if(users == null){
            return;
        }
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                if (users[i].getId() == id) {
                    users[i] = null;
                }
            }
        }
    }
}
