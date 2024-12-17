package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser("User1", "A", (byte) 10);
        userService.saveUser("User2", "B", (byte) 20);
        userService.saveUser("User3", "C", (byte) 30);
        userService.saveUser("User4", "D", (byte) 40);

        List<User> userList = userService.getAllUsers();
        System.out.println(userList);

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
