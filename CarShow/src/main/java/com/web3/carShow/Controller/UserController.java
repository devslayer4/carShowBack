package com.web3.carShow.Controller;

import com.web3.carShow.Model.User;
import com.web3.carShow.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;

    /* -- Test -- */

    @GetMapping("/HelloWorld")
    public String HelloWorld() {
        return "Hello World";
    }




    /*-- GET REQUEST --*/

    /* Get all user */
    @GetMapping("/user")
    public List<User> getAllUser() {
        return this.userService.getAllUsers();
    }

    /* Get user by id */
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return this.userService.getUserById(id);
    }

    @GetMapping("/user/{email}")
    public User getPasswordByEmail(@PathVariable String email) {
        return userService.getPasswordById(email);
    }




    /*-- PUT REQUEST --*/

    /* Update or change the current password */
    @PutMapping("/user/{id}")
    public User setUserPassword(@RequestBody User user, @PathVariable Long id) throws SQLException {
        return this.userService.updateUserPassword(user, id);
    }



    /*-- POST REQUEST --*/

    /* Create a new user */
    @PostMapping("/user")
    public User createUser (@RequestBody User user) {

        return userService.createUser(user);
    }



    /*-- DELETE REQUEST --*/

    /* Delete user by id */
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    /* Delete all users */
    @DeleteMapping("/user/all")
    public String deleteAllUser() {
        return userService.deleteAllUser();
    }
}
