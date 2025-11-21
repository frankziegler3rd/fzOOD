/**
 * OOD; Professor Chu
 * HW 5
 *
 * @author Frank Ziegler
 * @version 1.0.0
 */

package service;

import model.User;
import repo.UserRepo;

public class UserService implements IUserOps {

    private final UserRepo ur;

    public UserService() {
        ur = UserRepo.getInstance();
    }

    public boolean register(User user) {
        if(ur.findByUsername(user.getUsername()) == null && ur.findByPhoneNumber(user.getPhoneNumber()) == null) {
            return ur.addUser(user);
        }
        return false;
    }

    public boolean login(String username, String password) {
        User user = ur.findByUsername(username);
        if(user != null) {
            return user.getPassword().equals(password);
        }
        return false;
    }
}
