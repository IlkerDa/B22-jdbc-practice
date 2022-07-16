package jdbctests;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:oracle:thin:@44.204.228.18:1521:XE";
        String dbUsername = "hr";
        String dbPassword = "hr";

        Connection connection = DriverManager.getConnection(dbUrl,dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM regions ");

        //once you set up connection default pointer looks for 0
        //next() --> move pointer to first row
        resultSet.next();

        //getting information with column name
        System.out.println(resultSet.getString("region_name"));
        //getting information with column index(starts 1)
        System.out.println(resultSet.getString(2));
        System.out.println(resultSet.getInt(1));

        //close connection
        resultSet.close();
        statement.close();
        connection.close();
    }
}
