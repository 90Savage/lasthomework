package org.examples.javaee.class01.jdbc;

import java.sql.*;

public class TestJdbcV2 {
    public static String getMysql(){
        String url = "jdbc:mysql://127.0.0.1:3306/retail_db";
        String driverName = "com.mysql.jdbc.Driver";
        String sqlString = "select * from salary";
        String allUrl = url + "?user=root&password=123456";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int n = 100;
        while(n-- >= 0) {
            try {
                Class.forName(driverName);
                connection = DriverManager.getConnection(allUrl);
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sqlString);
                while(resultSet.next()){
                    String re = resultSet.getString("id");
                    System.out.println(re);
                }
                statement.close();
                connection.close();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            finally {
                if (null != resultSet) {
                    try {
                        resultSet.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (null != statement) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (null != connection) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return "";
    }
    public static void main(String[] args){
        getMysql();
    }
}
