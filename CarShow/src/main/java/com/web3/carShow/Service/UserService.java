package com.web3.carShow.Service;

import com.web3.carShow.Model.User;
import com.web3.carShow.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;



    /*-- CREATE --*/

    public User createUser(User user) {
        try {
            userRepository.createUser(user);
            return user;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



    /*-- READ --*/

    public List<User> getAllUsers() {
        try {
            return this.userRepository.getAlluser();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public User getUserById(Long id) {
        try {
            return this.userRepository.getUserById(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public User getPasswordById(String email) {
        try {
            return this.userRepository.getPasswordByEmail(email);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



    /*-- UPDATE --*/

    public User updateUserPassword(User user, Long id) throws SQLException {
        try {
            user.setId(id);
            userRepository.updateUserPassword(user, id);
            return user;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



    /*-- DELETE --*/

    public String deleteUser(Long id) {
        try {
            userRepository.deleteUser(id);
            return "User with id = " + id + " deleted !";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String deleteAllUser(){
        try {
            userRepository.deleteAllUser();
            return "All user are deleted";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
