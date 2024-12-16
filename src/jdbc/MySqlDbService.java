package jdbc;

import java.sql.*;

public class MySqlDbService extends DatabaseService
{
    @Override
    void createDatabase() throws SQLException
    {
        String createStatementQuery = "create schema if not exists quest_schema2";
        Connection connection = null;
        Statement statement = null;
        try
        {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(createStatementQuery);
            System.out.println("quest_schema2 created successfully");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (connection != null)
                connection.close();
            if (statement != null)
                statement.close();
        }
    }

    @Override
    public void createTable() throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS quest_schema2.student (id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(100), " +
                "age INT)";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement())
        {
            String useDatabaseQuery = "USE quest_schema2";
            statement.executeUpdate(useDatabaseQuery);

            statement.executeUpdate(createTableQuery);
            System.out.println("Table 'student' created successfully.");
        }
    }

    @Override
    void insertIntoTable() throws SQLException
    {
        String insertIntoTable="INSERT INTO quest_schema2.student (name, age) VALUES "+
                "('Hanan',23), "+
                "('Charles', 25), "+
                "('Seb',40), "+
                "('George',24)";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            String useDatabaseQuery = "USE quest_schema2";
            statement.executeUpdate(useDatabaseQuery);

            statement.executeUpdate(insertIntoTable);
            System.out.println("Data inserted successfully into 'student'");
        }
    }

    @Override
    public void readData() throws SQLException
    {
        String selectQuery = "SELECT * FROM quest_schema2.student";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery))
        {
            while (resultSet.next())
            {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }
        }
    }

    @Override
    void deleteFromTable(int studentId) throws SQLException
    {
        String deleteQuery = "DELETE FROM quest_schema2.student WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery))
        {

            //set the student id to delete
            preparedStatement.setInt(1, studentId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0)
            {
                System.out.println("Student with id " + studentId + " deleted successfully.");
            }
            else
            {
                System.out.println("No student found with ID " + studentId);
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error while deleting data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    void updateTable(int studentId, String newName, int newAge) {
        String updateQuery = "UPDATE quest_schema2.student SET name = ?, age = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            //set the values for the prepared statement
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, newAge);
            preparedStatement.setInt(3, studentId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student with ID " + studentId + " updated successfully.");
            } else {
                System.out.println("No student found with ID " + studentId);
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error while updating data: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
