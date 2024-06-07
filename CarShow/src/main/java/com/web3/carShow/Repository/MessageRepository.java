package com.web3.carShow.Repository;

import com.web3.carShow.Model.Car;
import com.web3.carShow.Model.Message;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class MessageRepository {
    private Connection connection;


    public Message createNewInstance(ResultSet resultSet) throws SQLException {
        return new Message(
                resultSet.getLong("id"),
                resultSet.getString("firstname"),
                resultSet.getString("lastname"),
                resultSet.getString("email"),
                resultSet.getString("message")
        );
    }



    /*-- CREATE --*/

    public void createMessage(Message message) throws SQLException {
        String sql = "INSERT INTO message (firstname, lastname, email, message) \n" +
                "VALUES (?,?,?,?);";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, message.getFirstname());
            statement.setString(2, message.getLastname());
            statement.setString(3, message.getEmail());
            statement.setString(4, message.getMessage());

            statement.executeUpdate();
        }
    }



    /*-- READ --*/

    public List<Message> getAllMessage() throws SQLException {
        String sql = "SELECT * FROM message";
        List<Message> list = new ArrayList<>();
        ResultSet resultSet = this.connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            list.add(createNewInstance(resultSet));
        }
        return list;
    }

    public Message getMessageById(Long id) throws SQLException {
        String sql = "SELECT * FROM message WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            return this.createNewInstance(resultSet);
        }
        return null;
    }



    /*-- DELETE --*/

    public void deleteMessageById(Long id) throws SQLException {
        String sql = "DELETE FROM message WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1, id);
            statement.executeQuery();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteAllMessage() throws SQLException {
        String sql = "DELETE FROM message";
        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.executeQuery();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
