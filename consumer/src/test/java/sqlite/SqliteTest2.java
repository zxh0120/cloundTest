package sqlite;

import java.sql.*;

/**
 * 加密数据 用户名密码不好使
 */
public class SqliteTest2 {
    public static void main(String[] args) throws SQLException {

        //    encrypt();
       decode();


    }

    public static void decode() throws SQLException {


        Statement statement;
        ResultSet rs;

        String  url = "jdbc:sqlite:file:database1.db?cipher=chacha20&key=my11EncryptionKey";
        String  user = "user";
        String   password = "password";
        Connection  connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
        statement.setQueryTimeout(30);  // set timeout to 30 sec.
        rs = statement.executeQuery("select * from person");
        while (rs.next()) {
            // read the result set
            System.out.println("name = " + rs.getString("name"));
            System.out.println("id = " + rs.getInt("id"));
        }
        connection.close();
    }


    private static void encrypt() throws SQLException {
        String url = "jdbc:sqlite:file:database1.db?cipher=chacha20&key=my11EncryptionKey";
        String user = "11";
        String password = "11";

        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);  // set timeout to 30 sec.

        statement.executeUpdate("create table person (id integer, name string)");
        statement.executeUpdate("insert into person values(1, 'leo')");
        statement.executeUpdate("insert into person values(2, 'yui')");
        ResultSet rs = statement.executeQuery("select * from person");
        while (rs.next()) {
            // read the result set
            System.out.println("name = " + rs.getString("name"));
            System.out.println("id = " + rs.getInt("id"));
        }
        connection.close();

        System.out.println("OTHER");
    }
}

