/**
 * OOD; Professor Chu
 * HW 5
 *
 * @author Frank Ziegler
 * @version 1.0.0
 */

package service;

import model.User;

public interface IUserOps {
    boolean register(User user);
    boolean login(String username, String password);
}
