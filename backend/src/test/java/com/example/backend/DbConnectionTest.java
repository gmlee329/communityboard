package com.example.backend;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.function.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
public class DbConnectionTest {
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
