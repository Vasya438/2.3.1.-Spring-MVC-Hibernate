package web.DAO;

import web.Model.User;

import java.util.ArrayList;
import java.util.List;

public interface UserDao {
    void addUser(User user);

    List<User> getAllUsers();
    User getUser(long id);
    void updateUser(User user);
    void deleteUser(long id);
}