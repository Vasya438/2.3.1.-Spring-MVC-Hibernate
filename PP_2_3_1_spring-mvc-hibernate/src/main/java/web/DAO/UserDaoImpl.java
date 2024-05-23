package web.DAO;



import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import web.Model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(getUser(id));
    }
}
//    private static int count;
//    private List<User> user;
//
//    {
//        user = new ArrayList<>();
//        user.add(new User(++count,"Ivan", "Ivanov@mail.ru"));
//        user.add(new User(++count, "Petr", "Petrov@mail.ru"));
//        user.add(new User(++count,"Sidor", "Sidorov@yandex.ru"));
//        user.add(new User(++count,"Kirill", "Voropaev@gmail.ru"));
//    }
//    public List<User> getAllUsers() {
//        return user;
//    }
//
//    public User show(int id) {
//        return user.stream().filter(u -> u.getId() == id).findAny().orElse(null);
//    }
//
//    public void save(User user) {
//        user.setId(++count);
//        this.user.add(user);
//    }
//
//    public void update(int id, User updatedUser) {
//        User userToBeUpdated = show(id);
//        userToBeUpdated.setName(updatedUser.getName());
//        userToBeUpdated.setEmail(updatedUser.getEmail());
//    }
//
//    public void delete(int id) {
//        user.removeIf(u -> u.getId() == id);
//    }

