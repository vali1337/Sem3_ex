package ro.ase.acs.classes;

import java.sql.Connection;
import java.sql.DriverManager;

public class Orchestrator {
    private final CreateTable createTable;
    private InsertData insertData;
    private final ReadData readData;

    public Orchestrator(CreateTable createTable, InsertData insertData, ReadData readData) {
        this.createTable = createTable;
        this.insertData = insertData;
        this.readData = readData;
    }

    public void startFlow() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            connection.setAutoCommit(false);

            CreateTable createMyTable = new CreateTable();
            createMyTable.createTable(connection);
            InsertData insertMyData = new InsertData();
            insertMyData.insertData(connection);
            ReadData readMyData = new ReadData();
            readMyData.readData(connection);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
