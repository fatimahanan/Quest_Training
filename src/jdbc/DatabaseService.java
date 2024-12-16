package jdbc;

import java.sql.SQLException;

public abstract class DatabaseService
{
   abstract void createDatabase() throws SQLException;
   abstract void createTable() throws SQLException;
   abstract void insertIntoTable() throws SQLException;
   abstract void readData() throws SQLException;
   abstract void deleteFromTable(int studentId) throws SQLException;
   abstract void updateTable(int studentId, String newName, int newAge);

}
