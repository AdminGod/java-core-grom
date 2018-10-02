package lessons.lesson27.hw2;

import java.util.ArrayList;

public class UserRepository {
    private ArrayList<User> users;

    public UserRepository(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public String[] getUserNames() {
        if(users != null) {
            String[] userNames = new String[users.size()];
            int counter = 0;
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i) != null) {
                    userNames[counter] = users.get(i).getName();
                    counter++;
                }
            }
            return userNames;
        }
        return new String[0];
    }

    public long[] getUserIds() {
        if(users != null) {
            long[] userIds = new long[users.size()];
            int counter = 0;
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i) != null) {
                    userIds[counter] = users.get(i).getId();
                    counter++;
                }
            }
            return userIds;
        }
        return new long[0];
    }

    public String getUserNameById(long id) {
        if(users!=null) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i) != null) {
                    if (users.get(i).getId() == id) {
                        return users.get(i).getName();
                    }
                }
            }
        }
        return null;
    }

    public User getUserByName(String name) {
        if(users!=null && name != null) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i) != null) {
                    if (users.get(i).getName() == name) {
                        return users.get(i);
                    }
                }
            }
        }
        return null;
    }

    private User findById(long id) {
        if(users!=null) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i) != null) {
                    if (users.get(i).getId() == id) {
                        return users.get(i);
                    }
                }
            }
        }
        return null;
    }

    public User getUserBySessionId(String sessionId) {
        if(users!= null) {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i) != null) {
                    if (users.get(i).getSessionId() == sessionId) {
                        return users.get(i);
                    }
                }
            }
        }
        return null;
    }

    public User save (User user){
        if(users == null){
            users = new ArrayList<>();
            users.add(user);
            return findById(user.getId());
        }
        if(findById(user.getId()) != null){
            return null;
        }
        users.add(user);
        return findById(user.getId());
    }

    public User update (User user){
        if(users == null || user == null){
            return null;
        }
        int index = users.indexOf(user);
        if(index != -1){
            users.set(index, user);
        }
        return null;
    }

    public void delete (long id){
        User user = findById(id);
        if(users == null || user == null){
            return;
        }
        users.remove(user);
    }
}
