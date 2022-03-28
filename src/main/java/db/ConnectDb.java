package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class ConnectDb {
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static Statement statement;
    static final String DB_URL = "jdbc:pg01.lt.gismt.crpt.tech";
}
