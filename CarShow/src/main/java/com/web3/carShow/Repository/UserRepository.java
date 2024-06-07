package com.web3.carShow.Repository;


import com.web3.carShow.Model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {
    private Connection connection;

    public User createNewInstance(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getString("phone"),
                resultSet.getString("password")
        );
    }


     /*-- CREATE --*/

    public void createUser(User user) throws SQLException {
        String sql = "INSERT INTO users (name, email, phone, password) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getPassword());

            preparedStatement.executeUpdate();
        }
    }



    /*-- READ --*/

    public List<User> getAlluser() throws SQLException {
        String sql = "SELECT * FROM users";
        List<User> list = new ArrayList<>();
        ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            list.add(createNewInstance(resultSet));
        }
        return list;
    }

    public User getUserById(long id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return createNewInstance(resultSet);
            }
        }
        return null;
    }

    public User getPasswordByEmail(String email) throws SQLException {
        String sql = "SELECT password FROM users WHERE email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return createNewInstance(resultSet);
            }
        }
        return null;
    }



    /*-- UPDATE --*/

    public void updateUserPassword(User user, Long id) throws SQLException {
        String sql = "UPDATE users SET password = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, user.getPassword());
            statement.setLong(2, id);
            statement.executeUpdate();
        }
    }



    /*-- DELETE --*/

    public void deleteUser(Long id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteAllUser() throws SQLException {
        String sql = "DELETE FROM users";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


}
