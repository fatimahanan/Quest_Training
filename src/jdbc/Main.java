package jdbc;

import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) throws SQLException {
        DatabaseService db=new MySqlDbService();
        db.createDatabase();
        db.createTable();
        db.insertIntoTable();
        db.readData();
        db.deleteFromTable(4);
        db.readData();
        db.updateTable(1,"lewis",30);
        db.readData();
    }
}
