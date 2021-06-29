package TRAININGJAVA;

import org.postgresql.core.SqlCommand;

import java.util.ArrayList;
import java.sql.*;

public class Main6 {

    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/training";
    static final String USER = "dbUser";
    static final String PASS = "MyPass";

    public static void main(String[] args) throws SQLException {


        String createSQLTable = "CREATE TABLE users" +
                "(id INTEGER not NULL, " +
                "firstName VARCHAR(30), " +
                "lastName VARCHAR(30), " +
                "companyID INTEGER not NULL, " +
                "role VARCHAR(30))";

        String insertUser1 = "INSERT INTO users VALUES(1, 'firstName1', 'lastName1', 4321, 'junior')";
        String insertUser2 = "INSERT INTO users VALUES(2, 'firstName2', 'lastName2', 4321, 'junior')";
        String insertUser3 = "INSERT INTO users VALUES(3, 'firstName3', 'lastName3', 4321, 'middle')";
        String insertUser4 = "INSERT INTO users VALUES(4, 'firstName4', 'lastName4', 4321, 'lead')";
        String insertUser5 = "INSERT INTO users VALUES(5, 'firstName5', 'lastName5', 4321, 'QA')";

        String getUser = "SELECT id, firstName, lastName, companyID, role FROM users";

    //create table users in training db
    try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = connection.createStatement();){
        statement.executeUpdate(createSQLTable);
        System.out.println("Table create successfully");
    }

    //add entries into users table
    try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = connection.createStatement();){
        statement.executeUpdate(insertUser1);
        System.out.println("Update table successfully");
    }

    //get entries from db to console
    try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(getUser);){

        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("id") +
                    " First name: " + resultSet.getString("firstName") +
                    " Last name: " + resultSet.getString("lastName") +
                    " Company ID: " + resultSet.getString("companyID") +
                    " Role: " + resultSet.getString("role"));
        }
    }
    }
}













