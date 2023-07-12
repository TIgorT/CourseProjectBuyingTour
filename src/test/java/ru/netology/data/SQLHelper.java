package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {
    private static QueryRunner runner = new QueryRunner();

    private SQLHelper() {

    }

    private static Connection getConn() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    @SneakyThrows
    public static void cleanDatabase() {
        var connection = getConn();
        runner.execute(connection, "DELETE FROM order_entity");
        runner.execute(connection, "DELETE FROM payment_entity");
    }

    @SneakyThrows
    public static void cleaningThePaymentEntity() {
        var connection = getConn();
        runner.execute(connection, "DELETE FROM payment_entity");
    }

    @SneakyThrows
    public static String getStatusPayments() {
        var sqlQuery = "SELECT status FROM payment_entity ORDER by created DESC LIMIT 1";
        var conn = getConn();
       String status = runner.query(conn, sqlQuery, new ScalarHandler<>());
       return status;
    }
}