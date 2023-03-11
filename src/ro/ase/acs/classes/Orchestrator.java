package ro.ase.acs.classes;

import ro.ase.acs.interfaces.DataInsertor;
import ro.ase.acs.interfaces.DataReader;
import ro.ase.acs.interfaces.TableCreator;

import java.sql.Connection;
import java.sql.DriverManager;

public class Orchestrator {
    private final TableCreator tableCreator;
    private DataInsertor dataInsertor;
    private final DataReader dataReader;

    public Orchestrator(TableCreator tableCreator, DataInsertor dataInsertor, DataReader dataReader) {
        this.tableCreator = tableCreator;
        this.dataInsertor = dataInsertor;
        this.dataReader = dataReader;
    }

    public void setDataInsertor(DataInsertor dataInsertor) {
        this.dataInsertor = dataInsertor;
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
