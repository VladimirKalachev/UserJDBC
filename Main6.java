package TRAININGJAVA;

import java.util.ArrayList;
import java.sql.*;
import java.util.Iterator;

public class Main6 {

    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/training";
    static final String USER = "dbUser";
    static final String PASS = "MyPass";

    public static void main(String[] args) throws SQLException {

        //1
        User user1 = new User();
        user1.setId(1);
        user1.setFirstName("Name1");
        user1.setLastName("LastName1");
        user1.setCompanyId(4321);
        user1.setRole("juniorDev");

        //2
        User user2 = new User();
        user2.setId(2);
        user2.setFirstName("Name2");
        user2.setLastName("LastName2");
        user2.setCompanyId(4321);
        user2.setRole("juniorDev");

        //3
        User user3 = new User();
        user3.setId(3);
        user3.setFirstName("Name3");
        user3.setLastName("LastName3");
        user3.setCompanyId(4321);
        user3.setRole("middleDev");

        //
        ArrayList userList = new ArrayList();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        String getUser = "SELECT id, firstName, lastName, companyID, role FROM users";
/*
        //create table users in training db

        String createSQLTable = "CREATE TABLE users" +
                "(id INTEGER not NULL, " +
                "firstName VARCHAR(30), " +
                "lastName VARCHAR(30), " +
                "companyID INTEGER not NULL, " +
                "role VARCHAR(30))";

        try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();){
            statement.executeUpdate(createSQLTable);
        } catch (SQLException e){
            e.printStackTrace();
        }
*/
        //create connection
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {

            //add entries into db
            Iterator iterator = userList.iterator();

            while (iterator.hasNext()) {
                User user = (User)iterator.next();
                String insertUser = "INSERT INTO users VALUES("
                        + user.getId() +   ", '"
                        + user.getFirstName() +  "', '"
                        + user.getLastName()  +  "', "
                        + user.getCompanyId()  +  ", '"
                        + user.getRole() + "')";
                 statement.executeUpdate(insertUser);
                }

            //get db entries & out to console
            ResultSet resultSet = statement.executeQuery(getUser);

            while (resultSet.next()) {
                System.out.println("| ID: " + resultSet.getInt("id") +
                        " | First name: " + resultSet.getString("firstName") +
                        " | Last name: " + resultSet.getString("lastName") +
                        " | Company ID: " + resultSet.getString("companyID") +
                        " | Role: " + resultSet.getString("role") + " |");
                }
            }
        }
    }
