package ru.netology.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;


public class SQLHelper {
    private static QueryRunner runner = new QueryRunner();

    private SQLHelper() {

    }

    @SneakyThrows
    private static Connection getConn() {
        return DriverManager.getConnection(System.getProperty("dbUrl"), "app", "pass");
    }


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

    @SneakyThrows
    public static List<PaymentEntity> getQuantityInTheDatabase() {
        var sqlQuery = "SELECT * FROM payment_entity ORDER by created DESC";
        var conn = getConn();
        var status = runner.query(conn, sqlQuery, new BeanListHandler<>(PaymentEntity.class));
        return status;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PaymentEntity {
        private String id;
        private int amount;
        private Timestamp created;
        private String status;
        private String transaction_id;
    }

}
