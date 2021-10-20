package com.example.backend;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@SpringBootTest
class BackendApplicationTests {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void dbConnectionTest() throws SQLException {
        try(Connection connection = dataSource.getConnection()) {
            log.info("dbcp : " + connection.getClass());
            log.info("url : " + connection.getMetaData().getURL());
            log.info("username : " + connection.getMetaData().getUserName());

        }
    }

}
