package TRAININGJAVA;

import org.postgresql.core.SqlCommand;

import java.util.ArrayList;
import java.sql.*;

public class Main6 {

    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/training";
    static final String USER = "dbUser";
    static final String PASS = "MyPass";

    public static void main(String[] args) throws SQLException {

        //registration jdbc

        System.out.println("Testing connection to PostgreSQL");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");

        Connection connection = null;

        //create connection to database

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }

        Statement statement = connection.createStatement();


        String createSQLTable = "CREATE TABLE user" +
                "(id INTEGER not NULL" +
                "firstName VARCHAR(30)" +
                "lastName VARCHAR(30)" +
                "companyID INTEGER not NULL" +
                "role VARCHAR(30))";

        String insertUser1 = "INSERT INTO user VALUES(1, 'firstName1', 'lastName1', 4321, 'junior')";
        String insertUser2 = "INSERT INTO user VALUES(2, 'firstName2', 'lastName2', 4321, 'junior')";
        String insertUser3 = "INSERT INTO user VALUES(3, 'firstName3', 'lastName3', 4321, 'middle')";
        String insertUser4 = "INSERT INTO user VALUES(4, 'firstName4', 'lastName4', 4321, 'lead')";
        String insertUser5 = "INSERT INTO user VALUES(5, 'firstName5', 'lastName5', 4321, 'QA')";

        String getUser = "SELECT * FROM user";


        //
        try (Connection connectionCreateDB = DriverManager.getConnection(DB_URL, USER, PASS))
            {
                statement.executeUpdate(createSQLTable);
            }catch (SQLException e){
                e.printStackTrace();
        }




    }
}












