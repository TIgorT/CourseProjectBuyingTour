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

    private static Connection getConn() throws SQLException {  // Для  MySQL
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");  // Для  MySQL
    }  // Для  MySQL


//    private static Connection getConn() throws SQLException { // Для PostgreSQL
//        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/app", "app", "pass"); // Для PostgreSQL
//    }// Для PostgreSQL

    @SneakyThrows
    public static void cleanDatabase() {
        var connection = getConn();
        runner.execute(connection, "DELETE FROM order_entity");
        runner.execute(connection, "DELETE FROM payment_entity");
        runner.execute(connection, "DELETE FROM credit_request_entity ");
    }

    @SneakyThrows
    public static String getStatusPayments() {
        var sqlQuery = "SELECT status FROM payment_entity ORDER by created DESC LIMIT 1";
        var conn = getConn();
       String status = runner.query(conn, sqlQuery, new ScalarHandler<>());
       return status;
    }

    @SneakyThrows
    public static String getStatusCreditPayments() {
        var sqlQuery = "SELECT status FROM credit_request_entity cre  ORDER by created DESC LIMIT 1";
        var conn = getConn();
        String status = runner.query(conn, sqlQuery, new ScalarHandler<>());
        return status;
    }

    @SneakyThrows
    public static int getThePaymentAmount() {
        var sqlQuery = "SELECT amount  FROM payment_entity ORDER by created DESC LIMIT 1";
        var conn = getConn();
        int status = runner.query(conn, sqlQuery, new ScalarHandler<>());
        return status;
    }
}
