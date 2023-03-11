package ro.ase.acs.classes;

import ro.ase.acs.interfaces.DataInsertor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        ServiceLocator serviceLocator = new ServiceLocator();
        Orchestrator orchestrator = new Orchestrator(
                serviceLocator.get(CreateTable.class),
                serviceLocator.get(InsertData.class),
                serviceLocator.get(ReadData.class));
        orchestrator.startFlow();
    }
}