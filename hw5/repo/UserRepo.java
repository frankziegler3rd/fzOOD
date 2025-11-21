/**
 * OOD; Professor Chu
 * HW 5
 *
 * @author Frank Ziegler
 * @version 1.0.0
 */

package repo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.util.ArrayList;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.io.IOException;
import java.io.FileWriter;
import model.User;

public class UserRepo {

    private String filePath;
    private Gson gson;
    private List<User> users;

    private UserRepo(String filePath) {
        this.gson = new Gson();
        this.users = new ArrayList<>();
        this.filePath = filePath;
        loadUsers();
    }
    
    // Bill Pugh singleton approach
    private static class Holder {
        static final UserRepo INSTANCE = new UserRepo("/Users/frankzigs/dev/OOD/hw5/repo/UserDB.json");
    }

    public static final UserRepo getInstance() { 
        return Holder.INSTANCE; 
    }

    private void loadUsers() {
        try(FileReader fr = new FileReader(filePath)) {
            Type listType = new TypeToken<List<User>>() {}.getType();
            this.users = gson.fromJson(fr, listType);
        } catch(IOException e) {
            this.users = new ArrayList<>();
        }
    }

    public User findByUsername(String username) {
        for(User user : users) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User findByPhoneNumber(String phoneNumber) {
        for(User user : users) {
            if(user.getPhoneNumber().equals(phoneNumber)) {
                return user;
            }
        }
        return null;
    }

    public User findByEmail(String email) {
        for(User user : users) {
            if(user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }


    public boolean addUser(User user) {
        try(FileWriter fw = new FileWriter(filePath)) {
            users.add(user);
            gson.toJson(users, fw);
            return true;
        } catch(IOException e) {
            return false;
        }
    }
}
