/**
 * OOD; Professor Chu
 * HW 5
 *
 * @author Frank Ziegler
 * @version 1.0.0
 */

package model;

public class User {
    
    private String name;
    private String username;
    private String phoneNumber;
    private String email;
    private String password;

    public User(String name, String username, String phoneNumber, String email, String password) {
        this.name = name;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
