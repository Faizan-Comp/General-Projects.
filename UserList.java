package system.user;

import system.exception.UserException;
import system.util.SystemUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;
import java.util.Optional;

/**
 * Manages a list of users, including adding, saving, loading, and logging in users.
 */
public class UserList {
    private final ArrayList<User> users = new ArrayList<>();
    private final String path = "src/system/user/";

    /**
     * Constructs a new UserList.
     */
    public UserList() {

    }

    /**
     * Adds a user to the user list after validating their data.
     *
     * @param user The user to be added.
     */
    public void addUser(User user) {
        String[] checkData = {user.getEmail(), user.getPassword(), user.getPlan().getType().toString(), String.valueOf(user.getPlan().isActive())};
        if (Arrays.stream(checkData).anyMatch(data -> !SystemUtil.isValid(data))) {
            new UserException("Invalid data is inputted");
        }
        users.add(user);
    }

    /**
     * Returns a string representation of the user list.
     *
     * @return A string listing all users or a message indicating the list is empty.
     */
    @Override
    public String toString() {
        StringBuilder userListString = new StringBuilder("USER LIST ............\n");
        try {
            if (users.isEmpty()) {
                throw new UserException("User list is empty");
            }

            users.forEach(user -> userListString.append(user).append("\n"));
            userListString.append("............................");
        } catch (UserException ignored) {}

        return userListString.toString();
    }

    /**
     * Saves the user list to a file.
     *
     * @param filename The name of the file to save the user list to.
     */
    public void saveUserList(String filename) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(path + filename));
            StringBuilder userList = new StringBuilder();
            String comma = ",";
            users.forEach(user -> {
                userList.append(user.getEmail() + comma);
                userList.append(user.getPassword() + comma);
                userList.append(user.getPlan().getType() + comma);
                userList.append(user.getPlan().isActive() + "\n");
            });
            writer.write(userList.toString());
            writer.close();
        } catch (Exception e) {
            new UserException("The file does not exist");
        }
    }

    /**
     * Loads users from a file and adds them to the user list.
     *
     * @param filename The name of the file to load users from.
     */
    public void loadUserList(String filename) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path + filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                users.add(User.createUser(data));
            }
            reader.close();
        } catch (Exception e) {
            new UserException("The file does not exist");
        }
    }

    /**
     * Logs in a user by email and password.
     *
     * @param email The email of the user.
     * @param pwd The password of the user.
     * @return The user if found, otherwise null.
     */
    public User login(String email, String pwd) {
        Optional<User> loginUser = users.stream().filter(user -> user.getEmail().equals(email) && user.getPassword().equals(pwd)).findFirst();

        return loginUser.orElse(null);
    }

    /**
     * Returns the list of users.
     *
     * @return The list of users.
     */
    public ArrayList<User> getUsers() {
        return users;
    }
}
