package db;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConnectDb {
    static final String DB_URL_SQL = "jdbc:mysql://localhost:3306/Cis";
    static final String login = "root";
    static final String password = "450125Ad";

    private static Connection connectionSql;
    private static Statement statementSql;
    private static PreparedStatement preparedStatement;



    public static void disconnectSql(){
        try {
            connectionSql.close();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public static void connectSql() {
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            connectionSql = DriverManager.getConnection(DB_URL_SQL,login,password);
            statementSql = connectionSql.createStatement();


        } catch (SQLException  e) {
            e.printStackTrace();
        }

    }

        public static void setBlockime(String phone) throws SQLException {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date date = new Date();
            //statementSql = connectionSql.prepareStatement("UPDATE `cis`.`users` SET `blocked` = '" +dateFormat.format(date) + "'WHERE (`phone` = '" + phone+"');");
            statementSql.execute("UPDATE `cis`.`users` SET `blocked` = '" +dateFormat.format(date) + "'WHERE (`phone` = '" + phone+"');");
        }

        public static void deleteSession(String phone) throws SQLException {
        statementSql.execute("Delete from `cis`.`session` where `phone` = '" + phone +"';");
        }

    public static void main(String[] args) throws SQLException {
        connectSql();
        setBlockime("124");
        deleteSession("123");
        disconnectSql();
    }
}


