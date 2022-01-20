package olzlrlo.crud.dao;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

@Log4j
public class JDBCTest {
    @Test
    public void testConnection() throws Exception{
        // Driver load
        Class.forName("com.mysql.cj.jdbc.Driver");
        log.info("------연결확인--------");

        String url = "jdbc:mysql://localhost:3306/member?serverTimezone=UTC";
        String username = "olzlrlo";
        String password = "000205";

        Connection con = DriverManager.getConnection(url,username,password);
        log.info(con);
        con.close();
    }
}
