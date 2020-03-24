package org.examples.javaee.class01.jdbc;

import java.sql.*;

public class TestJdbcV3 {
    public static String getMysql(){
        String url = "jdbc:mysql://127.0.0.1:3306/retail_db";
        String driverName = "com.mysql.jdbc.Driver";
        String sqlString = "select * from salary";
        String allUrl = url + "?user=root&password=123456";
        try {
            // 加载驱动
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int n = 100;

        while (n-- >= 0){
            try(Connection connection = DriverManager.getConnection(allUrl)) {
                try(Statement statement = connection.createStatement()){
                    try(ResultSet resultSet = statement.executeQuery(sqlString)){
                        // 获取执行结果
                        while (resultSet.next()){
                            System.out.println(resultSet.getString(4));
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
    public static void main(String[] args){
        getMysql();
    }
}
