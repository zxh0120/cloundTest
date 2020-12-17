package sqlite;




import java.sql.*;

/**
 *资料链接
 * aes 256
 * 验证工具 sqlite studio
 *  https://github.com/Willena/sqlite-jdbc-crypt#encryption_config_cipher
 * 正式的
 */
public class SqliteTest {
    public static void main(String[] args) throws SQLException {
         encrpty();
        //   test();
    }

    private static void encrpty() {
        Connection connection = null;
        try {
//            connection = SQLiteMCChacha20Config.getDefault().withKey("try123").
//             createConnection("jdbc:sqlite:sample4.db?cipher=sqlcipher&legacy=1&kdf_iter=4000&key=myHexKey");

//                connection = SQLiteMCWxAES128Config.getDefault().withKey("tryww1").
//                        createConnection("jdbc:sqlite:Atestdb.sqlite?cipher=aes128cbc&legacy=0&kdf_iter=4000&key=pawwws");

//            connection = SQLiteMCWxAES256Config.getDefault().withKey("1234567").
//                    createConnection("jdbc:sqlite:testdb.sqlite?cipher=aes256cbc&legacy=0&kdf_iter=4000&key=pawwws");

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            statement.executeUpdate("drop table if exists person");
            statement.executeUpdate("create table person (id integer, name string)");
            statement.executeUpdate("insert into person values(1, 'leo')");
            statement.executeUpdate("insert into person values(2, 'yui')");
            statement.executeUpdate("insert into person values(1, 'leo')");
            statement.executeUpdate("insert into person values(2, 'yui')");
            statement.executeUpdate("insert into person values(1, 'leo')");
            statement.executeUpdate("insert into person values(2, 'yui')");
            statement.executeUpdate("insert into person values(1, 'leo')");
            statement.executeUpdate("insert into person values(2, 'yui')");
            statement.executeUpdate("insert into person values(1, 'leo')");
            statement.executeUpdate("insert into person values(2, 'yui')");
            statement.executeUpdate("insert into person values(1, 'leo')");
            statement.executeUpdate("insert into person values(2, 'yui')");
            ResultSet rs = statement.executeQuery("SELECT id,name from  person");
            while (rs.next()) {
                System.out.println("id = " + rs.getString("id"));
                System.out.println("name = " + rs.getString("name"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void test() {
        Connection connection = null;
        try {
//           connection = DriverManager.getConnection("jdbc:sqlite:sample4.db",
//                   SQLiteMCChacha20Config.getDefault().withKey("try123").toProperties());

//             connection = DriverManager.getConnection("jdbc:sqlite:Atestdb.sqlite",
//                     SQLiteMCWxAES128Config.getDefault().withKey("tryww1").toProperties());

//            connection = DriverManager.getConnection("jdbc:sqlite:testdb.sqlite",
//                    SQLiteMCWxAES256Config.getDefault().withKey("1234567").toProperties());

//           connection = DriverManager.getConnection("jdbc:sqlite:D:/work/ideaWorkSpace/TestSqlite/src/main/resources/db/testdb.sqlite"
//                   , SQLiteMCWxAES256Config.getDefault().withKey("1234567").toProperties());

            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            ResultSet rs = statement.executeQuery("SELECT id,name from  person");
            while (rs.next()) {
                System.out.println("id = " + rs.getString("id"));
                System.out.println("name = " + rs.getString("name"));
            }
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }
}
