package com.example.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class BackendApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    DataSource dataSource;

    @Test
    public void testDbConnection() throws SQLException {
        try(Connection connection = dataSource.getConnection()) {
            System.out.println("dbcp : " + connection.getClass());
            System.out.println("url : " + connection.getMetaData().getURL());
            System.out.println("username : " + connection.getMetaData().getUserName());
        }
    }

}
