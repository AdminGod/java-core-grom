package lessons.lesson20.task1;

import lessons.lesson20.task1.exception.BadRequestException;
import lessons.lesson20.task1.exception.InternalServerException;
import lessons.lesson20.task1.exception.UserNotFoundException;

public class UserRepository {

    private User[] users;

    public User save (User user) throws Exception{
        if(user == null){
            throw new BadRequestException("Can't save null user");
        }
        try{
            findById(user.getId());
            throw new BadRequestException("User with id: " + user.getId() + " already exist");
        }catch (UserNotFoundException e){
            System.out.println("User with id: " + user.getId() + " not found. Will be saved");
        }

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return user;
            }
        }

        throw new InternalServerException("Not enough space to save user with id: " + user.getId());
    }

    public User update (User user) throws Exception{
        if(user == null){
            return null;
        }

        findById(user.getId());

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == user.getId()) {
                users[i] = user;
                return user;
            }
        }
        throw new InternalServerException("Unexpected error");
    }

    public void delete(long id) throws Exception{

        findById(id);

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == id) {
                users[i] = null;
                break;
            }
        }
    }

    public User findById(long id) throws UserNotFoundException {
        if(users!=null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i] != null && users[i].getId() == id) {
                    return users[i];
                }
            }
        }
        throw new UserNotFoundException("User with id: " + id + " not found");
    }

    public User[] getUsers(){
        return users;
    }
}
