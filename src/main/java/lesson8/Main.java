package lesson8;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite::memory:");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists weather");
            statement.executeUpdate("create table weather (city string, localDate string, weatherText string, temperature double)");
            statement.executeUpdate("insert into weather values('Moscow', '10-10-2020', 'Coldly', -37.7)");

            ResultSet rs = statement.executeQuery("select * from weather");
            while(rs.next())
            {
                // read the result set
                System.out.println("city = " + rs.getString("city"));
                System.out.println("localDate = " + rs.getString("localDate"));
                System.out.println("weatherText = " + rs.getString("weatherText"));
                System.out.println("temperature = " + rs.getFloat("temperature"));
            }
            // String city, String localDate, String weatherText, Double temperature
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }
}
