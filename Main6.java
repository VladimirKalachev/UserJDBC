package TRAININGJAVA;

import java.sql.*;
import java.util.ArrayList;

public class Main6 {

    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/training";
    static final String USER = "dbUser";
    static final String PASS = "MyPass";

    public static void main(String[] args) throws SQLException {
        //
        ArrayList<User> userList = new ArrayList();

        userList.add(new User(1, "Name1", "LastName1", 4321, "juniorDev"));
        userList.add(new User(2, "Name2", "LastName2", 4321, "middleDev"));
        userList.add(new User(3, "Name3", "LastName3", 4321, "QA"));

        String getUser = "SELECT id, first_name, last_name, company_id, role FROM users";

        //create table users in training db
        String createSQLTable = "CREATE TABLE users" +
                "(id INTEGER not NULL, " +
                "first_name VARCHAR(30), " +
                "last_name VARCHAR(30), " +
                "company_id INTEGER not NULL, " +
                "role VARCHAR(30))";

        try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement()){
            statement.executeUpdate(createSQLTable);
        } catch (SQLException e){
            e.printStackTrace();
        }

        //create connection
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = connection.createStatement()) {

            //add entries into db
            for (User user : userList) {
                String insertUser = "INSERT INTO users VALUES("
                        + user.getId() + ", '"
                        + user.getFirstName() + "', '"
                        + user.getLastName() + "', "
                        + user.getCompanyId() + ", '"
                        + user.getRole() + "')";
                statement.executeUpdate(insertUser);
            }

            //get db entries & out to console
            ResultSet resultSet = statement.executeQuery(getUser);

            while (resultSet.next()) {
                System.out.println("| ID: " + resultSet.getInt("id") +
                        " | First name: " + resultSet.getString("first_name") +
                        " | Last name: " + resultSet.getString("last_name") +
                        " | Company ID: " + resultSet.getString("company_id") +
                        " | Role: " + resultSet.getString("role") + " |");
            }
        }
    }
}
