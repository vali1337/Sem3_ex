package ro.ase.acs.classes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertMoreData extends InsertData{
    @Override
    public void insertData(Connection connection) throws SQLException {
        String sqlInsert = "INSERT INTO employees VALUES(3, 'Popa Vasile', 'Cluj', 6900)";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlInsert);
        statement.close();
        connection.commit();
    }
}
